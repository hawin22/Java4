package Servlet;

import entity.Ban;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.BanService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
        "/ban/hien-thi",
        "/ban/update",
        "/ban/delete"
})
public class BanServlet extends HttpServlet {
    BanService ser = new BanService();
    int page = 1;
    int soPhanTu = 10;
    String msg = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/update")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Ban ban = ser.findByID(id);
            req.setAttribute("update", ban);
        }
        if (uri.contains("/delete")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            ser.delete(id);
            msg = "Delete thành công";
        }
        if (uri.contains("/hien-thi")) {
            req.setAttribute("mssg", msg);
            msg = "";
        }
        req.setAttribute("list", listPhanTrang(page, soPhanTu, req, resp));
        req.setAttribute("listMQH", ser.getAllMQH());
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    public ArrayList<Ban> listPhanTrang(int page, int soPhanTu, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageString = req.getParameter("page");
        if (pageString == null) {
            page = 1;
        } else {
            page = Integer.valueOf(pageString);
        }
        int tongSoPhanTu = ser.getAllBan().size();
        int tongSoTrang = (int) Math.ceil((double) tongSoPhanTu / soPhanTu);
        req.setAttribute("sumPage", tongSoTrang);
        return ser.getAllBanPage(page, soPhanTu);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/update")) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Ban ban = ser.findByID(id);
            ban.setMa(req.getParameter("ma"));
            ban.setTen(req.getParameter("ten"));
            ban.setSothich(req.getParameter("sothich"));
            ban.setGioitinh(Integer.valueOf(req.getParameter("gioitinh")));
            Integer idMQH = Integer.valueOf(req.getParameter("mqh"));
            ban.setMqh(ser.getMQH(idMQH));
            ser.update(ban);
            msg = "Update thành công";
            resp.sendRedirect("hien-thi");
//            req.setAttribute("mssg", "Update thành công");
            return;
        } else {
            Ban b = new Ban();
            b.setMa(req.getParameter("ma"));
            b.setTen(req.getParameter("ten"));
            b.setSothich(req.getParameter("sothich"));
            b.setGioitinh(Integer.valueOf(req.getParameter("gioitinh")));
            Integer idMQH = Integer.valueOf(req.getParameter("mqh"));
            b.setMqh(ser.getMQH(idMQH));
            ser.add(b);
            msg = "Thêm thành công";
            resp.sendRedirect("hien-thi");
//            req.setAttribute("mssg", "Add thành công");
        }
        req.setAttribute("list", ser.getAllBan());
        req.setAttribute("listMQH", ser.getAllMQH());
    }
}
