package com.example.slide2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        System.out.println("gender: "+ gender);
        Boolean single = Boolean.valueOf(req.getParameter("single")) != null;
        System.out.println("Single: "+ single);
        String country = String.valueOf(req.getParameter("country"));
        System.out.println("Country: "+ country);
    }
}
