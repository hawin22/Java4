package model;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/home", "/addVD", "/updateVD", "/deleteVD"})
public class VideoServlet extends HttpServlet {
    VideoService videoService = new VideoService();
    Video videoTrong = new Video();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String id = req.getParameter("id");
        req.setAttribute("listvd", videoService.getAll().size());
        if (uri.contains("/home")) {
            req.setAttribute("listVD", videoService.getAll());
            req.getRequestDispatcher("/VideoView/VideoView.jsp").forward(req, resp);
        } else if (uri.contains("/addVD")) {
            req.getRequestDispatcher("/VideoView/VideoAdd.jsp").forward(req, resp);
        } else if (uri.contains("/updateVD")) {
            Video video1 = videoService.findVideo(id);
            req.setAttribute("updateVD", video1);
            req.getRequestDispatcher("/VideoView/VideoUpdate.jsp").forward(req, resp);
            videoTrong = video1;
        } else if (uri.contains("/deleteVD")) {
            videoService.delete(id);
            resp.sendRedirect("home");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        Boolean active = req.getParameter("active") != null;
        String poster = req.getParameter("poster");
        Video v = new Video(id, title, description, active, poster);
        String URI = req.getRequestURI();
        if (URI.contains("/addVD")) {
            if (check(req, resp, v)) {
                videoService.add(v);
            } else {
                req.setAttribute("v", v);
                req.getRequestDispatcher("/VideoView/VideoAdd.jsp").forward(req, resp);
            }
        }
        if (URI.contains("/updateVD")) {
            Video video2 = new Video(videoTrong.getId(), title, description, active, poster);
            if (checkUD(req, resp, video2)) {
                videoService.update(video2);
            } else {
                req.setAttribute("updateVD", video2);
                req.getRequestDispatcher("/VideoView/VideoUpdate.jsp").forward(req, resp);
            }
        }
        resp.sendRedirect("home");
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
            for (Video vd : videoService.lstVideo) {
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