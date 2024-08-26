package Servlet;

import Entity.SanPham;
import Service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/hien-thi",
        "/san-pham/detail",
        "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {
    SanPhamService ser = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI();
        if (uri.contains("/san-pham/update")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("sp", ser.findById(id));
        }
        req.setAttribute("list", ser.getAll());
        req.getRequestDispatcher("/view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPham sp = ser.findById(id);
        sp.setNambh(Integer.parseInt(req.getParameter("nambh")));
        sp.setSoluongton(Integer.parseInt(req.getParameter("soluongton")));
        sp.setGianhap(Double.parseDouble(req.getParameter("gianhap")));
        sp.setMota(req.getParameter("mota"));
        ser.update(sp);
//        req.getRequestDispatcher("/view.jsp").forward(req, resp);
        resp.sendRedirect("hien-thi");
    }
}
