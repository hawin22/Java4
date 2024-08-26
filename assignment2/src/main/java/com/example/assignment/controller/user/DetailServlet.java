package com.example.assignment.controller.user;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/detail", "/addDetail", "/deleteDetail"})
public class DetailServlet extends HttpServlet {
    VideoService ser = new VideoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String id = req.getParameter("id");
        String username = (String) req.getSession().getAttribute("username");
        Video video = ser.findVideo(id);
        req.setAttribute("video", video);
        Boolean like;
        if (uri.contains("/addDetail")) {
            ser.addListLike(id, ser.getIDByEmail(username));
            like = true;
        }
        if (uri.contains("/deleteDetail")) {
            ser.deleteListLike(id, ser.getIDByEmail(username));
            like = false;
        }
        if (checkLike(id, username)) {
            like = true;
            req.setAttribute("like", like);

        } else {
            like = false;
            req.setAttribute("like", like);


        }
        req.setAttribute("requestURI", req.getRequestURI());
        req.getRequestDispatcher("/view/detail.jsp").forward(req, resp);
    }

    Boolean checkLike(String id, String username) {
        int count = 0;
        try {
            for (Video v : ser.listFavorite(ser.getIDByEmail(username))) {
                if (v.getId().trim().equals(id)) {
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count == 0) {
            return false;
        }
        return true;
    }

}
