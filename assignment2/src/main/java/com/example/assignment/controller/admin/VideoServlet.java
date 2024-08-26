package com.example.assignment.controller.admin;

import com.example.assignment.entity.Video;
import com.example.assignment.service.VideoService;
import com.example.assignment.service.impl.VideoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/video/*")
public class VideoServlet extends HttpServlet {
    VideoService videoService = new VideoServiceImpl();
    Video videoTrong = new Video();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        req.setAttribute("listvd", videoService.getAll().size());
        if (uri.contains("/video/updateVD")) {
            String id = req.getParameter("id");
            Video video1 = videoService.findVideo(id);
            req.setAttribute("updateVD", video1);
            req.getRequestDispatcher("/view/VideoView/VideoUpdate.jsp").forward(req, resp);
            videoTrong = video1;
        }else if (uri.contains("/video/addVD")){
            req.getRequestDispatcher("/view/VideoView/VideoAdd.jsp").forward(req, resp);
        }
        else if (uri.contains("/video/deleteVD")) {
            String id = req.getParameter("id");
            videoService.delete(id);
            resp.sendRedirect("video");
            return;
        }
        req.setAttribute("listVD", videoService.getAll());
        req.getRequestDispatcher("/view/VideoView/VideoView.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI();
        if (URI.contains("/video/addVD")) {
            Video v = new Video();
            v.setId(req.getParameter("id"));
            v.setTitle(req.getParameter("title"));
            v.setDescription(req.getParameter("description"));
            v.setActive(req.getParameter("active") != null);
            v.setPoster(req.getParameter("poster"));
            if (check(req, resp, v)) {
                videoService.add(v);
            } else {
                req.setAttribute("v", v);
                req.getRequestDispatcher("/view/VideoView/VideoAdd.jsp").forward(req, resp);
            }
        }
        if (URI.contains("/video/updateVD")) {
            String title = req.getParameter("title");
            String description = req.getParameter("description");
            Boolean active = req.getParameter("active") != null;
            String poster = req.getParameter("poster");
            Video video2 = new Video(videoTrong.getId(), title, poster, description, videoTrong.getViews(), active);
            if (checkUD(req, resp, video2)) {
                videoService.update(video2);
            } else {
                req.setAttribute("updateVD", video2);
                req.getRequestDispatcher("/view/VideoView/VideoUpdate.jsp").forward(req, resp);
            }
        }
        resp.sendRedirect("video");
    }

    private Boolean check(HttpServletRequest req, HttpServletResponse resp, Video v) throws ServletException, IOException {
        int count = 0;
        if (v.getTitle().trim().isEmpty()) {
            count++;
            req.setAttribute("tTitle", "Không được để trống title");
        }
        if (v.getPoster().trim().isEmpty()) {
            count++;
            req.setAttribute("tPoster", "Không được để trống poster");
        }
        if (v.getId().trim().isEmpty()) {
            count++;
            req.setAttribute("tID", "Không được để trống id");
        } else {
            int c = 0;
            for (Video vd : videoService.getAll()) {
                if (v.getId().equalsIgnoreCase(vd.getId())) {
                    c++;
                }
            }
            if (c > 0) {
                req.setAttribute("trID", "Trùng ID rùi :(((");
                return false;
            } else {
                return true;
            }
        }


        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean checkUD(HttpServletRequest req, HttpServletResponse resp, Video v) throws ServletException, IOException {
        int count = 0;

        if (v.getTitle().trim().isEmpty()) {
            count++;
            req.setAttribute("tTitle", "Không được để trống title");
        }
        if (v.getPoster().trim().isEmpty()) {
            count++;
            req.setAttribute("tPoster", "Không được để trống poster");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
