package com.example.Lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/bai1", "/chuVi", "/dienTich"})
public class Bai1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai1.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        double c = Double.parseDouble(req.getParameter("c"));
        double p = (a+b+c)/2;
        String uri = req.getRequestURI();
        if (uri.contains("chuVi")) {
            req.setAttribute("chuVi", a+b+c);

        }else if(uri.contains("dienTich")) {
            req.setAttribute("dienTich", p * (p - a) * (p - b) * (p - c));
        }
        req.getRequestDispatcher("/bai1.jsp").forward(req,resp);
    }
}
