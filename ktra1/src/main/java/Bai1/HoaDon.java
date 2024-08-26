package Bai1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/bai1")
public class HoaDon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Bai1/result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float donGia = Float.parseFloat(req.getParameter("donGia"));
        float soLuong = Float.parseFloat(req.getParameter("soLuong"));
        float thue = Float.parseFloat(req.getParameter("thue"));
        float tinhTien = soLuong*donGia*(1+thue/100);
        req.setAttribute("tinhTien", tinhTien);
        req.getRequestDispatcher("/Bai1/result.jsp").forward(req,resp);
    }

}
