package com.example.assignment.service.impl;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;

import java.util.ArrayList;
import java.util.Map;

public class UserServiceMockImpl implements UserService {
    @Override
    public boolean checkUser(String username, String password) {
        return "poly".equals(username) && "123".equals(password);
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }


    @Override
    public User findID(String id) {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Map<String, String> HashMap() {
        return null;
    }

}
