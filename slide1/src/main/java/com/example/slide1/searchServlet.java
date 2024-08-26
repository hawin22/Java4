package com.example.slide1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet ("/search")
public class searchServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("q");
//        resp.getWriter().println("Hello world");
        resp.getWriter().println("Keyword: " + keyword);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
//        resp.sendRedirect("/slide1_war_exploded/hello-servlet");
    }
}
