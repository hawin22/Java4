package Service;

import Entity.SanPham;
import com.example.kiemtra2.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class SanPhamService {
    public ArrayList<SanPham> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "Select sp from SanPham sp";
            Query q = em.createQuery(jdql);
            return (ArrayList<SanPham>) q.getResultList();
        }
        finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        SanPhamService ser = new SanPhamService();
        for (SanPham sp: ser.getAll()) {
            System.out.println(sp.getId()+": "+sp.getMota());
        }
    }
    public SanPham findById(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(SanPham.class,id);
        }
        finally {
            em.close();
        }
    }
    public void update(SanPham sp){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sp);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}
