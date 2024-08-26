package com.demo.exam.repository;

import com.demo.exam.HibernateUtil;
import com.demo.exam.entity.Ban;
import com.demo.exam.entity.MoiQuanHe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class BanRepo {
    public List<MoiQuanHe> getDsMoiQuanHe(){
        EntityManager em =
                HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT m FROM MoiQuanHe m";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public List<Ban> getPage(int page, int pageSize){
        EntityManager em =
                HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT b FROM Ban b";
            Query q = em.createQuery(jpql);
            q.setFirstResult(page * pageSize);
            q.setMaxResults(pageSize);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public List<Ban> findAll(){
        EntityManager em =
            HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT b FROM Ban b";
            Query q = em.createQuery(jpql);
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public List<Ban> search(String keyword){
        EntityManager em =
                HibernateUtil.createEntityManager();
        try{
            String jpql = "SELECT b FROM Ban b WHERE b.ten LIKE :kw";
            Query q = em.createQuery(jpql);
            q.setParameter("kw", "%" + keyword + "%");
            return q.getResultList();
        }finally {
            em.close();
        }
    }

    public Ban findById(Integer id){
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Ban.class, id);
        }finally {
            em.close();
        }
    }

    public void add(Ban ban){
        EntityManager em = HibernateUtil.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(ban);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public static void main(String[] args){
        BanRepo repo = new BanRepo();
        for(Ban b : repo.findAll()){
            System.out.println(b.getTen());
        }
    }
}
