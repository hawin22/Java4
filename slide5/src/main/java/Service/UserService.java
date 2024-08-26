package Service;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import com.example.slide5.HibernateUtil;
import java.util.List;
public class UserService {
    public List<User> findAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "SELECT u FROM User u";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public void add(User user){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void update(User user){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public User findById(String id){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            return em.find(User.class, id);
        }finally {
            em.close();
        }
    }

    public void deleteById(String id){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            User user = em.find(User.class, id);
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args){
        // Test find all
        UserService service = new UserService();
        for(User u : service.findAll()){
            System.out.println(u.getId());
        }
        // Test create
        User user = new User();
        user.setId("admin2");
        user.setPassword("123");
        user.setAdmin(true);
        service.add(user);

        // Test update
        user = service.findById("admin");
        user.setPassword("abc123");
        service.update(user);

        // Test delete
        service.deleteById("admin2");
    }
}
