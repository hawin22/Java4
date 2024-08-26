package Bai2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/bai2")
public class computerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Bai2/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        req.setAttribute("ma", ma);
        String ten = req.getParameter("ten");
        req.setAttribute("ten",ten);
        double gia = Double.parseDouble(req.getParameter("gia"));
        req.setAttribute("gia", gia);
        String mauSac = req.getParameter("mauSac");
        req.setAttribute("mauSac", mauSac);
        String hang = req.getParameter("hang");
        req.setAttribute("hang", hang);
        Boolean status = req.getParameter("status") != null ;
        req.setAttribute("status", status ? "Yes" : "No");
        req.getRequestDispatcher("/Bai2/result.jsp").forward(req,resp);
    }
}
