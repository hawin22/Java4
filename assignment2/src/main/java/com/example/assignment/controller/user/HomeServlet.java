package com.example.assignment.controller.user;

import com.example.assignment.ServiceFactory;
import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
//    VideoService service = ServiceFactory.getVideoService();

    VideoService ser = new VideoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        if(keyword == null) keyword = "";
        System.out.println("In home, keyword=" + keyword);
        if (keyword.trim().isEmpty()||keyword==null ){
            req.setAttribute("items", ser.getAll());
        }
        else{
            req.setAttribute("items", ser.search(keyword));
        }
//        List<Video> items = ser.getAll();
        req.setAttribute("requestURI", req.getRequestURI());
//        req.setAttribute("items", items);
        req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
    }
}
