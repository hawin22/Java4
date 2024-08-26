package com.example.Lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    List<User> list = new ArrayList<>();

    public UserService() {
        list.add(new User("admin", "1122", true));
        list.add(new User("user", "1133", false));
    }


    public List<User> getAll() {
        return list;
    }

    public void add(User u) {
        list.add(u);
    }

    public User findByID(String id) {
        for (User u : list) {
            if (u.getId().equals(id))
                return u;
        }
        return null;
    }

    public void deleteByID(String id) {
        User u = findByID(id);
        if (u != null)
            list.remove(u);
    }
public void update(User u){
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i).getId().equals(u.getId())){
            list.set(i,u);
        }
    }
}
}
