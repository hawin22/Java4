package Service;

import Entity.KhachHang;
import com.example.demau1.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class KhachHangService {
    public ArrayList<KhachHang> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "Select kh from KhachHang kh";
            Query q = em.createQuery(jdql);
            return (ArrayList<KhachHang>)q.getResultList();
        }
        finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        KhachHangService service = new KhachHangService();
        for (KhachHang kh: service.getAll()) {
            System.out.println(kh.getHo()+""+kh.getTen());
        }
    }
    public KhachHang findByID(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(KhachHang.class,id);
        }
        finally {
            em.close();
        }
    }
    public void update(KhachHang kh){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(kh);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
