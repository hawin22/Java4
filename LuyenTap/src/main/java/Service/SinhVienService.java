package Service;

import Entity.SinhVien;
import com.example.LuyenTap.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class SinhVienService {
    public ArrayList<SinhVien> getAll(){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "Select sv from SinhVien sv";
            Query q = em.createQuery(jdql);
            return (ArrayList<SinhVien>) q.getResultList();
        }
        finally {
            em.close();
        }
    }
    public static void main(String[] args) {
        SinhVienService service = new SinhVienService();
        for (SinhVien sv: service.getAll()) {
            System.out.println(sv.getMa()+": "+sv.getTen());
        }
    }
    public SinhVien findById(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(SinhVien.class,id);
        }
        finally {
            em.close();
        }
    }
    public void addSV(SinhVien sinhVien){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(sinhVien);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    public void deleteSV(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            SinhVien sv = em.find(SinhVien.class,id);
            em.remove(sv);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
    public void updateSV(SinhVien sv){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sv);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}
