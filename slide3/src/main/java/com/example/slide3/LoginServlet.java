package com.example.slide3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = null;
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals("username")) {
                username = c.getValue();
            }
        }
        req.setAttribute("username", username);
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Cookie c = new Cookie("username", username);
        c.setMaxAge(24 * 3600); // 24h
        resp.addCookie(c);
        resp.sendRedirect("login");
    }
}
