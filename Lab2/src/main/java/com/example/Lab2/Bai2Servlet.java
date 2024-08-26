package com.example.Lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet ("/bai2")
public class Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/bai2/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usename = req.getParameter("username");
        req.setAttribute("username", usename);
        String pass = req.getParameter("pass");
        req.setAttribute("pass",pass);
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        req.setAttribute("gender", gender ? "Nam" : "Nữ");
        Boolean status = req.getParameter("status") != null ;
        req.setAttribute("status", status ? "Yes" : "No");
        String[] mang = req.getParameterValues("hobbies");
        System.out.println("hobbies"+ Arrays.toString(mang));
        req.setAttribute("hobbies", mang);
        String country = req.getParameter("country");
        req.setAttribute("country", country);
        String note = req.getParameter("note");
        req.setAttribute("note",note);
        req.getRequestDispatcher("/bai2/success.jsp").forward(req,resp);
    }
}
