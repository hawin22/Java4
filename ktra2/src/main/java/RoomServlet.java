import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/phong")
public class RoomServlet extends HttpServlet {
    RoomService roomService = new RoomService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("list",roomService.getAll());
        req.getRequestDispatcher("/Room.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String soPhong = req.getParameter("soPhong");
        String loaiPhong = req.getParameter("loaiPhong");
        String tang = req.getParameter("tang");
        Boolean trangThai = req.getParameter("trangThai") !=null;
        Room room = new Room(soPhong,loaiPhong, tang,trangThai);
        roomService.add(room);
        resp.sendRedirect("phong");
    }
}
