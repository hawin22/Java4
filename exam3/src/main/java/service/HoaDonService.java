package service;

import com.demo.exam.HibernateUtil;
import entity.HoaDon;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class HoaDonService {
    public ArrayList<HoaDon> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select hd from HoaDon hd";
            Query q = em.createQuery(sql);
            return (ArrayList<HoaDon>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<HoaDon> getNhanVien() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select nv from NhanVien nv";
            Query q = em.createQuery(sql);
            return (ArrayList<HoaDon>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public NhanVien findByIdNV(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(NhanVien.class, id);
        } finally {
            em.close();
        }
    }
    public ArrayList<HoaDon> getPhanTrang(int trang, int soPhanTu) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select hd from HoaDon hd";
            Query q = em.createQuery(sql);
            q.setFirstResult((trang - 1) * soPhanTu);
            q.setMaxResults(soPhanTu);
            return (ArrayList<HoaDon>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        HoaDonService ser = new HoaDonService();
        for (HoaDon h : ser.getAll()) {
            System.out.println("soLuong: " + h.getNgaynhan());
        }
    }

    public HoaDon findById(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(HoaDon.class, id);
        } finally {
            em.close();
        }
    }


    public void add(HoaDon h) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(HoaDon h) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(h);
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
