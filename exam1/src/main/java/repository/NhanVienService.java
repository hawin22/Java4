package repository;

import com.demo.exam.HibernateUtil;
import entity.ChucVu;
import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class NhanVienService {
    public ArrayList<NhanVien> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select nv from NhanVien nv";
            Query q = em.createQuery(sql);
            return (ArrayList<NhanVien>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<NhanVien> getPage(int trangIndex, int soPhanTu) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select nv from NhanVien nv";
            Query q = em.createQuery(sql);
            q.setFirstResult((trangIndex-1)*soPhanTu);
            q.setMaxResults(soPhanTu);
            return (ArrayList<NhanVien>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<ChucVu> getChucVu() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select cv from ChucVu cv";
            Query q = em.createQuery(sql);
            return (ArrayList<ChucVu>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ChucVu findByIdCV(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(ChucVu.class, id);
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        NhanVienService ser = new NhanVienService();
        for (NhanVien nv : ser.getAll()) {
            System.out.println(nv.getId() + ": " + nv.getTen());
        }
    }

    public void add(NhanVien nv) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nv);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public NhanVien findById(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        return em.find(NhanVien.class, id);
    }

    public void update(NhanVien nv) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(nv);
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
