package com.example.Lab5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/user", "/update-user", "/delete-user"})
public class UserServlet extends HttpServlet {
    UserService ser = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        if (URI.contains("/delete-user")){
            // TODO: delete
            String id = req.getParameter("id");
            ser.deleteById(id);
            resp.sendRedirect("user");
            return;
        }
        if (URI.contains("/update-user")){
            String id = req.getParameter("id");
            User currentUser = ser.findById(id);
            req.setAttribute("currentUser",currentUser);
        }
        req.setAttribute("list", ser.findAll());
        req.getRequestDispatcher("/view/user/index.jsp").forward(req, resp);
    }

    void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User u = ser.findById(id);
        u.setPassword(req.getParameter("password"));
        u.setAdmin(req.getParameter("admin") != null);
        ser.update(u);
        resp.sendRedirect("user");
//        User u = new User();
//        u.setId(req.getParameter("id"));
//        u.setPassword(req.getParameter("password"));
//        u.setAdmin(req.getParameter("admin") != null);
//        resp.sendRedirect("user");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        if (URI.contains("/update-user")) {
            update(req, resp);
            return;
        }
        User u = new User();
        u.setId(req.getParameter("id"));
        u.setPassword(req.getParameter("password"));
        u.setAdmin(req.getParameter("admin") != null);
        ser.add(u);
        resp.sendRedirect("user");
    }
}
