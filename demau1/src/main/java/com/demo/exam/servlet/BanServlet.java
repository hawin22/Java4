package com.demo.exam.servlet;

import com.demo.exam.entity.Ban;
import com.demo.exam.repository.BanRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
    "/ban/hien-thi",
    "/ban/add",
    "/ban/detail",
    "/ban/tim-kiem",
    "/ban/phan-trang" // localhost:8080/.../phan-trang?page=0
})
public class BanServlet extends HttpServlet {
    BanRepo repo = new BanRepo();
    void timKiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        req.setAttribute("list", repo.search(keyword));
        req.getRequestDispatcher("/views/ban/hien-thi.jsp").forward(req, resp);
    }

    void phanTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageSize = 5;
        int page = Integer.valueOf(req.getParameter("page")); // starting from 0
        req.setAttribute("list", repo.getPage(page, pageSize));
        req.setAttribute("offset", page * pageSize);
        req.getRequestDispatcher("/views/ban/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/phan-trang")){
            phanTrang(req, resp);
        }
        if(uri.contains("/tim-kiem")){
            timKiem(req, resp);
            return;
        }
        if(uri.contains("/detail")){
            Integer id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("msg", "Hiển thị chi tiết thành công");
            req.setAttribute("banDetail", repo.findById(id));
        }
        if(req.getParameter("add-success") != null){
            req.setAttribute("msg", "Thêm mới thành công");
        }
        req.setAttribute("dsMQH", repo.getDsMoiQuanHe());
        req.setAttribute("list", repo.findAll());
        req.getRequestDispatcher("/views/ban/hien-thi.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ban ban = new Ban();
        ban.setMa(req.getParameter("ma"));
        ban.setTen(req.getParameter("ten"));
        ban.setGioitinh(Boolean.valueOf(req.getParameter("gioitinh")));
        ban.setSothich(req.getParameter("sothich"));
        repo.add(ban);
        resp.sendRedirect("hien-thi?add-success=true");
    }
}
