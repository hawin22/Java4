package Servlet;

import Entity.SinhVien;
import Service.SinhVienService;
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
        "/sinhvien",
        "/updateSV",
        "/deleteSV"
})
public class SinhVienServlet extends HttpServlet {
    SinhVienService ser = new SinhVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/updateSV")) {
            int id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("sv", ser.findById(id));
            req.getRequestDispatcher("/update.jsp").forward(req, resp);
            return;
        }
        if (uri.contains("/deleteSV")) {
            int id = Integer.valueOf(req.getParameter("id"));
            ser.deleteSV(id);
            resp.sendRedirect("sinhvien");
            return;
        }
        req.setAttribute("list", ser.getAll());
        req.getRequestDispatcher("/view.jsp").forward(req, resp);

    }

    Date parseDate(String st) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        try {
            return sdf.parse(st);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/updateSV")) {
            int id = Integer.parseInt(req.getParameter("id"));
            SinhVien sinhVien = ser.findById(id);
            sinhVien.setMa(req.getParameter("ma"));
            sinhVien.setTen(req.getParameter("ten"));
            sinhVien.setNgaysinh(parseDate(req.getParameter("ngaysinh")));
            sinhVien.setGioitinh(Boolean.parseBoolean(req.getParameter("gioitinh")));
            sinhVien.setNganhhoc(req.getParameter("nganhhoc"));
            sinhVien.setTrangthai(req.getParameter("trangthai") != null);
            ser.updateSV(sinhVien);
            resp.sendRedirect("sinhvien");
            return;
        }
            SinhVien sv = new SinhVien();
            sv.setMa(req.getParameter("ma"));
            sv.setTen(req.getParameter("ten"));
            sv.setNgaysinh(parseDate(req.getParameter("ngaysinh")));
            sv.setGioitinh(Boolean.parseBoolean(req.getParameter("gioitinh")));
            sv.setNganhhoc(req.getParameter("nganhhoc"));
            sv.setTrangthai(req.getParameter("trangthai") != null);
            ser.addSV(sv);
                resp.sendRedirect("sinhvien");

    }
}
