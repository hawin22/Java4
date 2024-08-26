package servlet;

import entity.PhieuGiamGia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.PhieuGiamGiaService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/PhieuGiamGia/hien-thi",
        "/PhieuGiamGia/view-add",
        "/PhieuGiamGia/add",
        "/PhieuGiamGia/view-update",
        "/PhieuGiamGia/update",
        "/PhieuGiamGia/detail",
        "/PhieuGiamGia/delete"
})
public class PhieuGiamGiaServlet extends HttpServlet {
    PhieuGiamGiaService ser = new PhieuGiamGiaService();
    String msg = "";
    int trang = 1;
    int soPhanTu = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String hienthi = req.getParameter("show");
        if (uri.contains("/hien-thi")) {
            req.setAttribute("msg", msg);
            msg = "";
            req.setAttribute("view", hienthi);
            req.setAttribute("list", phanTrang(trang, soPhanTu, req, resp));
        }
        if (uri.contains("/detail")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("pgg", ser.findById(id));
            req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);
        }
        if (uri.contains("/view-add")) {
            req.setAttribute("listLP", ser.getLoaiPhieu());
            req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
        }
        if (uri.contains("/view-update")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("listLP", ser.getLoaiPhieu());
            req.setAttribute("pgg", ser.findById(id));
            req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
        }
        if (uri.contains("/delete")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            ser.delete(id);
            msg = "Xoá thành công";
            resp.sendRedirect("hien-thi?show=true");
            return;
        }
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    public ArrayList<PhieuGiamGia> phanTrang(int trang, int soPhanTu, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trangPage = req.getParameter("page");
        if (trangPage == null) {
            trang = 1;
        } else {
            trang = Integer.valueOf(trangPage);
        }
        int tongSoPhanTu = ser.getAll().size();
        int soTrang = (int) Math.ceil((double) tongSoPhanTu / soPhanTu);
        req.setAttribute("tongSoTrang", soTrang);
        return ser.getPhanTrang(trang, soPhanTu);
    }

    public boolean checkTrong(PhieuGiamGia p, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        if (p.getTen().trim().isEmpty()) {
            count++;
            req.setAttribute("trTen", "không được trống tên");
        }
        if (String.valueOf(p.getSoluong()).trim().isEmpty()) {
            count++;
            req.setAttribute("trSL", "không được trống số lượng");
        }
        if (p.getLoaigiam().trim().isEmpty()) {
            count++;
            req.setAttribute("trLG", "không được trống loại giảm");
        }
        if (p.getGiatritoida().equals("Mời mời")) {
            count++;
            req.setAttribute("trGT", "Chưa chọn giá trị tối đa");

        }
        if (p.getLoaiPhieu().getMa().equals("Mời mời")) {
            count++;
            req.setAttribute("trGT", "Chưa chọn mã loại phiếu");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/add")) {
            Integer idlp = Integer.valueOf(req.getParameter("idlp"));
            PhieuGiamGia p = new PhieuGiamGia();
            p.setTen(req.getParameter("ten"));
            p.setSoluong(Integer.valueOf(req.getParameter("soluong")));
            p.setLoaigiam(req.getParameter("loaigiam"));
            p.setGiatritoida(req.getParameter("giatritoida"));
            p.setLoaiPhieu(ser.findByIdLP(idlp));
            if (checkTrong(p, req, resp)) {
                ser.add(p);
                msg = "Thêm thành công";
                resp.sendRedirect("hien-thi?show=true");
            } else {
                req.setAttribute("listLP", ser.getLoaiPhieu());
                req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
            }
        } else if (uri.contains("/update")) {
            Integer idlp = Integer.valueOf(req.getParameter("idlp"));
            Integer id = Integer.valueOf(req.getParameter("id"));
            PhieuGiamGia p = ser.findById(id);
            p.setTen(req.getParameter("ten"));
            p.setSoluong(Integer.valueOf(req.getParameter("soluong")));
            p.setLoaigiam(req.getParameter("loaigiam"));
            p.setGiatritoida(req.getParameter("giatritoida"));
            p.setLoaiPhieu(ser.findByIdLP(idlp));
            ser.update(p);
            msg = "Sửa thành công";
            resp.sendRedirect("hien-thi?show=true");
        }
    }
}
