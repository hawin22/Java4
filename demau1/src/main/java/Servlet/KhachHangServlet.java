package Servlet;

import Entity.KhachHang;
import Service.KhachHangService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet({
        ("/khach-hang/hien-thi"),
        ("/khach-hang/update"),
        ("/khach-hang/delete"),
        ("/khach-hang/view-update")
})
public class KhachHangServlet extends HttpServlet {
    KhachHangService ser = new KhachHangService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/khach-hang/view-update")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("kh",ser.findByID(id));
            req.getRequestDispatcher("/views/khach-hang/update.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("list",ser.getAll());
        req.getRequestDispatcher("/views/khach-hang/index.jsp").forward(req,resp);

    }
Date parseDate(String st){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    try {
        return sdf.parse(st);
    } catch (ParseException e) {
        return null;
    }
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        KhachHang kh = ser.findByID(id);
        kh.setTen(req.getParameter("ten"));
        kh.setSdt(req.getParameter("sdt"));
        kh.setNgaysinh(parseDate(req.getParameter("ngaysinh")));
        kh.setDiachi(req.getParameter("diachi"));
        kh.setMatkhau(req.getParameter("matkhau"));
        boolean error = false;
        if (kh.getTen().trim().isEmpty()){
            req.setAttribute("er","Mời bạn nhập tên");
        }
        if (kh.getNgaysinh() == null){
            req.setAttribute("erNS","Mời bạn nhập ngày sinh");
        }
        ser.update(kh);
        resp.sendRedirect("khach-hang/hien-thi");
    }
}
