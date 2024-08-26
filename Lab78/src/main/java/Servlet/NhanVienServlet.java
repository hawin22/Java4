package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NhanVienService;

import java.io.IOException;

@WebServlet({"/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/delete"
})
public class NhanVienServlet extends HttpServlet {
    NhanVienService ser = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();

        if (uri.contains("/detail")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("nv", ser.detail(id));
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
        }
        if (uri.contains("/delete")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            ser.delete(id);
            req.setAttribute("message","Xoá thành công");
            resp.sendRedirect("hien-thi");
            return;
        }
//        if (req.getParameter("delete-success")!=null){
//        }
        req.setAttribute("list", ser.getAll());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }


//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uri = req.getRequestURI();
//        if (uri.contains("/delete")){
//            resp.sendRedirect("/nhan-vien/hien-thi?delete-success=true");
//        }
//    }
}
