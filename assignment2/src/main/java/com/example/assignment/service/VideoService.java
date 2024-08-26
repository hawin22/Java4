package com.example.assignment.service;

import com.example.assignment.entity.Favorite;
import com.example.assignment.entity.Video;

import java.util.ArrayList;
import java.util.List;

public interface VideoService {
    ArrayList<Video> getAll();
    Video findVideo(String id);
    void add(Video v);
    void update(Video v);
    void delete(String id);
    ArrayList<Video> search(String keyword);
    ArrayList<Video> searchFavorite(String userId, String keyword);
    ArrayList<Video> listFavorite(String userId);
    String getIDByEmail(String email);
    void addListLike(String idVideo, String username);
    void deleteListLike(String id, String username);
    ArrayList<Favorite> listLike(String id);
}
