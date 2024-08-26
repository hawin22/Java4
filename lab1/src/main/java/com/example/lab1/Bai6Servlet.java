package com.example.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/bai6")
public class Bai6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai6/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dai = req.getParameter("dai");
        double cd = Double.parseDouble(dai);
        String rong = req.getParameter("rong");
        double cr = Double.parseDouble(rong);
        double dt = cd*cr;
        double cv = (cd + cr)*2;
        req.setAttribute("s",dt);
        req.setAttribute("p",cv);
        req.getRequestDispatcher("/bai6/result.jsp").forward(req,resp);
    }
}
