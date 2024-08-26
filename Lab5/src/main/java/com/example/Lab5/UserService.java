package com.example.Lab5;

import jakarta.persistence.*;

import java.util.ArrayList;

public class UserService {
    public ArrayList<User> findAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "Select u from User u";
            Query q = em.createQuery(jpql);
            return (ArrayList<User>) q.getResultList();
        } finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        UserService ser = new UserService();
        for (User u : ser.findAll()) {
            System.out.println(u.getId() + " : " + u.getPassword());
        }
    }

    public void add(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            User u = em.find(User.class, id);
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public User findById(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public void update(User u) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
