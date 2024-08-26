package com.example.assignment.service;

import com.example.assignment.entity.User;

import java.util.ArrayList;
import java.util.Map;

public interface UserService {
    boolean checkUser(String username, String password);
    ArrayList<User> getAll();
    User findID(String id);
    void add(User user);
    void update(User user);
    void delete(String id);
    Map<String, String> HashMap();
}

