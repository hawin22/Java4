package com.example.Lab4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/user",
        "/delete-user",
        "/update-user"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        System.out.println(uri);
        if (uri.contains("/delete-user")){
            String id = req.getParameter("id");
            System.out.println("id: "+ id);
            userService.deleteByID(id);
            resp.sendRedirect("user");
            return;
        }
        if (uri.contains("/update-user")){
            String id = req.getParameter("id");
            User u = userService.findByID(id);
            req.setAttribute("currentUser",u);
        }
        req.setAttribute("list", userService.getAll());
        req.getRequestDispatcher("/user/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        Boolean admin = req.getParameter("admin") != null;
        User u = new User(id, password, admin);
        if (req.getRequestURI().contains("/update-user")){
            userService.update(u);
        }else {
            userService.add(u);
        }
        resp.sendRedirect("user");
    }
}
