package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.*;

public class UserServiceImpl implements UserService {

    @Override
    public boolean checkUser(String username, String password) {
        // TODO
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "select u from User u";
            Query q = em.createQuery(jdql);
            return (ArrayList<User>) q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public User findID(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }


    @Override
    public void add(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(User user) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            User user = em.find(User.class, id);
            if (user != null) {
                // Tìm các Favorite liên quan đến User
                ArrayList<Favorite> favorites = (ArrayList<Favorite>) em.createQuery(
                        "SELECT f FROM Favorite f WHERE f.user.id = :userId", Favorite.class)
                        .setParameter("userId", id)
                        .getResultList();
                for (Favorite favorite : favorites) {
                    em.remove(favorite);
                }
            }
            em.remove(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


//    public static void main(String[] args) {
//        UserService service = new UserServiceImpl();
////        service.delete("tt");
//        for (User sv : service.getAll()) {
//            System.out.println(sv.getId() + ": " + sv.getFullname());
//        }
//    }


    @Override
    public Map<String, String> HashMap() {
        Map<String, String> listUserPass = new HashMap<>();
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            for (User u : getAll()) {
                listUserPass.put(u.getEmail(), u.getPassword());
            }
            return listUserPass;
        } finally {
            em.close();
        }
    }
}
