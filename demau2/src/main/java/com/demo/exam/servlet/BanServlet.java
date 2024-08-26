package com.demo.exam.servlet;

import com.demo.exam.entity.Ban;
import com.demo.exam.repository.BanRepo;
import com.demo.exam.request.BanRequest;
import com.demo.exam.response.BanReponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
    "/ban/hien-thi",
    "/ban/update",
})
public class BanServlet extends HttpServlet {
    BanRepo repo = new BanRepo();

    List<BanReponse> entityToResponse(List<Ban> list){
        List<BanReponse> listResp = new ArrayList<>();
        for(Ban ban : list){
            listResp.add(new BanReponse(ban));
        }
        return listResp;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("/update")){
            Integer id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("msg", "Hiển thị chi tiết thành công");
            req.setAttribute("banDetail", repo.findById(id));
        }
        if(req.getParameter("update-success") != null){
            req.setAttribute("msg", "Cập nhật thành công");
        }
        req.setAttribute("dsMQH", repo.getDsMoiQuanHe());
        List<Ban> list = repo.findAll();
        req.setAttribute("list", entityToResponse(list));
        req.getRequestDispatcher("/views/ban/hien-thi.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BanRequest banRequest = new BanRequest();
        banRequest.setMa(req.getParameter("ma"));
        banRequest.setTen(req.getParameter("ten"));

        banRequest.setSothich(req.getParameter("sothich"));
        boolean hasError = false;

        if(banRequest.getMa().isEmpty()){
            req.setAttribute("errorMa", "Mã không được trống");
            hasError = true;
        }

        if(banRequest.getTen().isEmpty()){
            req.setAttribute("errorTen", "Tên không được trống");
            hasError = true;
        }

        if(banRequest.getSothich().isEmpty()){
            req.setAttribute("errorSothich", "Sở thích không được trống");
            hasError = true;
        }

        if(req.getParameter("gioitinh") == null){
            req.setAttribute("errorGioitinh", "Giới tính không được trống");
            hasError = true;
        }else{
            banRequest.setGioitinh(Boolean.valueOf(req.getParameter("gioitinh")));
        }

        if(hasError){
            req.getRequestDispatcher("/views/ban/hien-thi.jsp")
                .forward(req, resp);
        }else {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Ban ban = repo.findById(id);
            banRequest.copyToEntity(ban);
            repo.update(ban);
            resp.sendRedirect("hien-thi?update-success=true");
        }
    }
}
