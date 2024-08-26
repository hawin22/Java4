package com.example.slide3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet("/sinhVien")
public class SinhVienServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/sinhVien/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SinhVien sv = new SinhVien();
       try {
           BeanUtils.populate(sv, req.getParameterMap());
       }
       catch (Exception e){
           e.printStackTrace();
       }
       req.setAttribute("sv", sv);
       req.getRequestDispatcher("/sinhVien/result.jsp").forward(req,resp);
       /* String ma = req.getParameter("ma");
        String hoTen = req.getParameter("hoTen");
        String email = req.getParameter("email");
        String SDT = req.getParameter("SDT");
        String diaChi = req.getParameter("diaChi");*/
    }
}
