package com.example.assignment.service.impl;

import com.example.assignment.HibernateUtil;
import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.User;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class VideoServiceImpl implements VideoService {
    @Override
    public ArrayList<Video> getAll() {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "select v from Video v";
            Query q = em.createQuery(jdql);
            return (ArrayList<Video>) q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Video findVideo(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void add(Video v) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(v);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Video v) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(v);
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
            Video v = em.find(Video.class, id);
            if (v != null) {
                ArrayList<Favorite> favorites = (ArrayList<Favorite>) em.createQuery(
                        "SELECT f FROM Favorite f WHERE f.video.id = :id", Favorite.class)
                        .setParameter("id", id)
                        .getResultList();
                for (Favorite favorite : favorites) {
                    em.remove(favorite);
                }
                em.remove(v);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    public static void main(String[] args) {
        VideoService ser = new VideoServiceImpl();
        System.out.println(ser.getAll().toString());
    }

    @Override
    public ArrayList<Video> search(String keyword) {
        //TODO
        ArrayList<Video> listSearch = new ArrayList<>();
        for (Video v : getAll()) {
            if (v.getTitle().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                listSearch.add(v);
            }
        }
        return listSearch;
    }


    @Override
    public ArrayList<Video> listFavorite(String userId) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jdql = "select v from Video v\n" +
                    "join Favorite f on f.video = v.id\n" +
                    "join User u on u.id = f.user\n" +
                    "where u.id = :userID";
            Query q = em.createQuery(jdql, Video.class);
            q.setParameter("userID", userId);
            return (ArrayList<Video>) q.getResultList();
        } catch (NoResultException e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public String getIDByEmail(String email) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String jpql = "select u.id from User u where u.email=:email";
            Query q = em.createQuery(jpql);
            q.setParameter("email", email);
            return (String) q.getSingleResult();
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<Video> searchFavorite(String userId, String keyword) {
        //TODO
        ArrayList<Video> listSearch = new ArrayList<>();
        for (Video v : listFavorite(userId)) {
            if (v.getTitle().toLowerCase(Locale.ROOT).contains(keyword.toLowerCase(Locale.ROOT))) {
                listSearch.add(v);
            }
        }
        return listSearch;
    }

    //    @Override
//    public void addListLike(Favorite f) {
//        EntityManager em = HibernateUtil.createEntityManager();
//        try {
//            String jdql = "select v.id from Video v ";
//            Query q = em.createQuery(jdql);
//            ArrayList<Video> listID = (ArrayList<Video>) q.getResultList();
//            em.getTransaction().begin();
//            for (Video v : listID) {
//                if (v.getId().equals(f.getId())) {
//                    em.persist(f);
//                }
//                em.getTransaction().commit();
//            }
//        } finally {
//            em.close();
//        }
//    }
    LocalDate date = LocalDate.now();

    @Override
    public void addListLike(String idVideo, String username) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            User user = em.find(User.class, username);
            Video video = em.find(Video.class, idVideo);
            Favorite favorite = new Favorite(user, video);
            if (user != null && video != null) {
                em.getTransaction().begin();
                em.persist(favorite);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<Favorite> listLike(String id) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            String sql = "select f from Favorite f where f.id=:id";
            Query q = em.createQuery(sql);
            q.setParameter("id", id);
            return (ArrayList<Favorite>) q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteListLike(String id, String username) {
        EntityManager em = HibernateUtil.createEntityManager();
        try {
            em.getTransaction().begin();
            String jdql = "select f from Favorite f where f.video.id=:id and f.user.id=:username";
            Query q = em.createQuery(jdql);
            q.setParameter("id", id).setParameter("username", username);
            Favorite fv = (Favorite) q.getSingleResult();
            em.remove(fv);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
//        EntityManager em = HibernateUtil.createEntityManager();
////        EntityTransaction transaction = em.getTransaction();
//        try {
//            em.getTransaction().begin();
//            User user = em.find(User.class, username);
//            Video video = em.find(Video.class, id);
////            Favorite favorite = new Favorite(user,video);
//            if (user != null && video != null) {
//                S
//                Favorite favorite = (Favorite) q.setParameter("id", id).setParameter("username", username).getSingleResult();
//                if (favorite != null) {
//                    em.remove(favorite);
//                }
//            }
//            em.getTransaction().commit();
////        } catch (Exception e) {
////            if (transaction.isActive()) {
////                transaction.rollback();
////            }
////            throw new RuntimeException(e);
//        } finally {
//            em.close();
//        }

}
