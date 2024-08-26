package servlet;

import entity.HoaDon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.taglibs.standard.tag.common.fmt.ParseDateSupport;
import service.HoaDonService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({
        "/hien-thi",
        "/add",
        "/update",
        "/detail",
        "/delete"
})
public class HoaDonServlet extends HttpServlet {
    HoaDonService ser = new HoaDonService();
    int trang = 1;
    int soPhanTu = 10;
    String msg = "";
    String pageString = "";

    public ArrayList<HoaDon> phanTrang(int trang, int soPhanTu, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trangIndex = req.getParameter("page");
        if (trangIndex == null) {
            trang = 1;
        } else {
            trang = Integer.valueOf(trangIndex);
        }
        int tongSoPhanTu = ser.getAll().size();
        int soTrang = (int) Math.ceil((double) tongSoPhanTu / soPhanTu);
        req.setAttribute("tongSoTrang", soTrang);
        return ser.getPhanTrang(trang, soPhanTu);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String hienthi = req.getParameter("show");
        if (uri.contains("/hien-thi")) {
            req.setAttribute("msg", msg);
            msg = "";
            req.setAttribute("listNV", ser.getNhanVien());
            pageString = req.getParameter("page");

        } else if (uri.contains("/update")) {
            req.setAttribute("listNV", ser.getNhanVien());
            req.setAttribute("hd", ser.findById(Integer.valueOf(req.getParameter("id"))));
        } else if (uri.contains("/detail")) {
            req.setAttribute("listNV", ser.getNhanVien());
            req.setAttribute("hd", ser.findById(Integer.valueOf(req.getParameter("id"))));
        } else if (uri.contains("/delete")) {
            ser.delete(Integer.valueOf(req.getParameter("id")));
            msg = "Xoá thành công";
            resp.sendRedirect("hien-thi?show=true");
            return;
        }
        req.setAttribute("view", hienthi);
        req.setAttribute("list", phanTrang(trang, soPhanTu, req, resp));
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    Date parseDate(String d) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return s.parse(d);
        } catch (ParseException e) {
            return null;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        boolean check = false;
        if (req.getParameter("ma").trim().isEmpty()) {
            req.setAttribute("trMa", "Không được trống mã");
            check = true;
        }
        if (req.getParameter("ngaytao").trim().isEmpty()) {
            req.setAttribute("trngayTao", "Không được trống ngày tạo");
            check = true;
        }
        if (req.getParameter("ngaythanhtoan").trim().isEmpty()) {
            req.setAttribute("trngayThanhToan", "Không được trống ngày thanh toán");
            check = true;
        }
        if (req.getParameter("ngayship").trim().isEmpty()) {
            req.setAttribute("trngayShip", "Không được trống ngày ship");
            check = true;
        }
        if (req.getParameter("ngaynhan").trim().isEmpty()) {
            req.setAttribute("trngayNhan", "Không được trống ngày nhận");
            check = true;
        }
        String tt = req.getParameter("tinhtrang");
        if (tt == null || tt.isEmpty()) {
            req.setAttribute("trtinhTrang", "Không được trống tình trạng");
            check = true;
        }
//        if (tt != null || !tt.isEmpty()) {
//
//        } else {
//            System.out.println(req.getParameter("tinhtrang") + "Tình trạng");
//            req.setAttribute("trtinhTrang", "Không được trống tình trạng");
//            check = true;
//        }
        if (uri.contains("/update")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            HoaDon h = ser.findById(id);
            h.setMa(req.getParameter("ma"));
            h.setNgaytao(parseDate(req.getParameter("ngaytao")));
            h.setNgaythanhtoan(parseDate(req.getParameter("ngaythanhtoan")));
            h.setNgayship(parseDate(req.getParameter("ngayship")));
            h.setNgaynhan(parseDate(req.getParameter("ngaynhan")));
            h.setTinhtrang(Integer.valueOf(req.getParameter("tinhtrang")));
            Integer idnv = Integer.valueOf(req.getParameter("idnv"));
            h.setNhanVien(ser.findByIdNV(idnv));
            if (check) {
                req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
            } else {
                ser.update(h);
                msg = "Update thành công";
                resp.sendRedirect("hien-thi?show=true&page=" + pageString);
            }
        } else {
            HoaDon h = new HoaDon();
            h.setMa(req.getParameter("ma"));
            h.setNgaytao(parseDate(req.getParameter("ngaytao")));
            h.setNgaythanhtoan(parseDate(req.getParameter("ngaythanhtoan")));
            h.setNgayship(parseDate(req.getParameter("ngayship")));
            h.setNgaynhan(parseDate(req.getParameter("ngaynhan")));
            if (req.getParameter("tinhtrang") == null) {
                h.setTinhtrang(-1);
            } else {
                h.setTinhtrang(Integer.valueOf(req.getParameter("tinhtrang")));
            }
            Integer idnv = Integer.valueOf(req.getParameter("idnv"));
            h.setNhanVien(ser.findByIdNV(idnv));
            if (check) {
                req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
            } else {
                ser.add(h);
                msg = "Thêm thành công";
                resp.sendRedirect("hien-thi?show=true");
            }
        }
    }
}
