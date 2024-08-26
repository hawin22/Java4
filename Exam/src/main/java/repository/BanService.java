package repository;

import com.demo.exam.HibernateUtil;
import entity.Ban;
import entity.MQH;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;

public class BanService {
    public ArrayList<Ban> getAllBan() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select b from Ban b";
            Query q = em.createQuery(sql);
            return (ArrayList<Ban>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<Ban> getAllBanPage(int page, int soPhanTu) {
        int begin = (page - 1) * soPhanTu;
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select b from Ban b";
            Query q = em.createQuery(sql);
            q.setFirstResult(begin);
            q.setMaxResults(soPhanTu);
            return (ArrayList<Ban>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public ArrayList<MQH> getAllMQH() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select m from MQH m";
            Query q = em.createQuery(sql);
            return (ArrayList<MQH>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public MQH getMQH(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(MQH.class, id);
        } finally {
            em.close();
        }
    }

    public Ban findByID(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Ban.class, id);
        } finally {
            em.close();
        }
    }

    public void add(Ban ban) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ban);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void update(Ban ban) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(ban);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(findByID(id));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
