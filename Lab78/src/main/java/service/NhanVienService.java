package service;

import Entity.NhanVien;
import com.example.Lab78.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;

public class NhanVienService {
    public ArrayList<NhanVien> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select n from NhanVien n";
            Query q = em.createQuery(sql);
            return (ArrayList<NhanVien>) q.getResultList();
        }
        finally {
            em.close();
        }
    }
    public NhanVien detail(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(NhanVien.class,id);
        }
        finally {
            em.close();
        }
    }
    public void delete(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(NhanVien.class,id));
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}
