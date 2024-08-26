package servlet;

import entity.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.NhanVienService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/delete",
        "/nhan-vien/view-add",
        "/nhan-vien/view-update",
        "/nhan-vien/update"
})
public class NhanVienServlet extends HttpServlet {
    NhanVienService ser = new NhanVienService();
    String msg = "";
    int trang = 1;
    int soPhanTu = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hienthi = req.getParameter("show");
        String uri = req.getRequestURI();
        if (uri.contains("/view-add")) {
            req.setAttribute("listCV", ser.getChucVu());
            req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
        }
        if (uri.contains("/hien-thi")) {
            req.setAttribute("mssg", msg);
            msg = "";
            req.setAttribute("view", hienthi);
            req.setAttribute("list", phanTrang(trang, soPhanTu,req,resp));
        }
        if (uri.contains("/detail")) {
            req.setAttribute("nv", ser.findById(Integer.valueOf(req.getParameter("id"))));
            req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);
        }
        if (uri.contains("/view-update")) {
            req.setAttribute("listCV", ser.getChucVu());
            req.setAttribute("nv", ser.findById(Integer.valueOf(req.getParameter("id"))));
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

    public ArrayList<NhanVien> phanTrang(int trang, int soPhanTu, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trangIndex = req.getParameter("page");
        if (trangIndex == null){
            trang = 1;
        }
        else{
            trang = Integer.valueOf(trangIndex);
        }
        int sumPhanTu = ser.getAll().size();
        int tongSoTrang = (int) Math.ceil((double) sumPhanTu/soPhanTu);
        req.setAttribute("tongSoTrang", tongSoTrang);
        return ser.getPage(trang, soPhanTu);
    }

    public boolean checkTrong(NhanVien nv, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        if (nv.getMa().trim().isEmpty()) {
            count++;
            req.setAttribute("trMa", "Không được trống mã");
        }
        if (nv.getTen().trim().isEmpty()) {
            count++;
            req.setAttribute("trTen", "Không được trống tên");
        }
        if (nv.getDiachi().trim().isEmpty()) {
            count++;
            req.setAttribute("trDc", "Không được trống địa chỉ");
        }
        if (!nv.getGioitinh().equals("Nam") && !nv.getGioitinh().equals("Nữ")) {
            count++;
            req.setAttribute("trGt", "Chưa chọn giới tính");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("/add")) {
            NhanVien nv = new NhanVien();
            nv.setMa(req.getParameter("ma"));
            nv.setTen(req.getParameter("ten"));
            String gt = req.getParameter("gioitinh");
            if (gt == null) {
                gt = "";
            } else {
                gt = req.getParameter("gioitinh");
            }
            nv.setGioitinh(gt);
            Integer idcv = Integer.valueOf(req.getParameter("idcv"));
            nv.setChucVu(ser.findByIdCV(idcv));
            nv.setDiachi(req.getParameter("diachi"));
            if (checkTrong(nv, req, resp)) {
                ser.add(nv);
                msg = "Thêm thành công";
                resp.sendRedirect("hien-thi?show=true");
            } else {
                req.getRequestDispatcher("/view/add.jsp").forward(req, resp);
            }
        } else if (req.getRequestURI().contains("/update")) {
            NhanVien nv = ser.findById(Integer.valueOf(req.getParameter("id")));
            nv.setMa(req.getParameter("ma"));
            nv.setTen(req.getParameter("ten"));
            nv.setGioitinh(req.getParameter("gioitinh"));
            Integer idcv = Integer.valueOf(req.getParameter("idcv"));
            System.out.println("iđu" + idcv);
            nv.setChucVu(ser.findByIdCV(idcv));
            nv.setDiachi(req.getParameter("diachi"));
            if (checkTrong(nv, req, resp)) {
                ser.update(nv);
                msg = "Úp đết thành công";
                resp.sendRedirect("hien-thi?show=true");
            } else {
                req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
            }
        }
    }
}
