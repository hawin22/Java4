package repository;

import com.demo.exam.HibernateUtil;
import entity.LoaiPhieu;
import entity.PhieuGiamGia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class PhieuGiamGiaService {
    public ArrayList<PhieuGiamGia> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select p from PhieuGiamGia p";
            Query q = em.createQuery(sql);
            return (ArrayList<PhieuGiamGia>) q.getResultList();
        } finally {
            em.close();
        }
    } public ArrayList<PhieuGiamGia> getPhanTrang(int trang, int soPhanTu) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select p from PhieuGiamGia p";
            Query q = em.createQuery(sql);
            q.setFirstResult((trang-1)*soPhanTu);
            q.setMaxResults(soPhanTu);
            return (ArrayList<PhieuGiamGia>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<LoaiPhieu> getLoaiPhieu() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select l from LoaiPhieu l";
            Query q = em.createQuery(sql);
            return (ArrayList<LoaiPhieu>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public LoaiPhieu findByIdLP(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(LoaiPhieu.class, id);
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        PhieuGiamGiaService ser = new PhieuGiamGiaService();
        for (PhieuGiamGia p : ser.getAll()) {
            System.out.println("ten: " + p.getTen());
        }
    }

    public PhieuGiamGia findById(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(PhieuGiamGia.class, id);
        } finally {
            em.close();
        }
    }


    public void add(PhieuGiamGia p) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(PhieuGiamGia p) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(findById(id));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
