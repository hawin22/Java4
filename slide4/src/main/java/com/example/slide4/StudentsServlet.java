package com.example.slide4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/student")
public class StudentsServlet extends HttpServlet {
    List<Students> list = Arrays.asList(
            new Students("PH1001", "Nguyen Van A"),
            new Students("PH1002", "Nguyen Van B")
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list", list);
        req.getRequestDispatcher("/student.jsp").forward(req,resp);
    }
}
