package com.example.Lab3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;


import java.io.IOException;

@WebServlet("/Bai2")
public class Bai2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Bai2/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee em = new Employee();
        DateConverter dtc = new DateConverter();
        dtc.setPattern("dd/MM/yyyy");
        ConvertUtils.register(dtc, java.util.Date.class);
        try {
            BeanUtils.populate(em, req.getParameterMap());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        req.setAttribute("em", em);
        req.getRequestDispatcher("/Bai2/result.jsp").forward(req,resp);
    }
}
