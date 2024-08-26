package com.example.assignment.controller.admin;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;
import com.example.assignment.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    User userTrong = new User();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URI = request.getRequestURI();
        request.setAttribute("r", userService.getAll().size());
        if (URI.contains("/user/delete")) {
            String id = request.getParameter("id");
            userService.delete(id);
            response.sendRedirect("user");
            return;
        }
        if (URI.contains("/user/update")) {
            String id = request.getParameter("id");
            User user1 = userService.findID(id);
            request.setAttribute("update", user1);
            request.getRequestDispatcher("/view/UserView/UserUpdate.jsp").forward(request, response);
            userTrong = user1;
        }
        if (URI.contains("/user/add")){
            request.getRequestDispatcher("/view/UserView/UserAdd.jsp").forward(request, response);
        }
        request.setAttribute("list", userService.getAll());
        request.getRequestDispatcher("/view/UserView/UserView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URI = request.getRequestURI();
        if (URI.contains("/user/update")) {
            String email = request.getParameter("email");
            String fullname = request.getParameter("fullname");
            Boolean admin = request.getParameter("admin") != null;
            User user = new User(userTrong.getId(), userTrong.getPassword(), fullname, email, admin);
            if (checkTrongUD(email, fullname, request, response) && checkTrungEmail(email, userTrong, request, response)) {
                Boolean click = true;
                click = true;
                request.setAttribute("onclick", click);
                userService.update(user);
//                System.out.println(user.toString());
            } else {
                request.setAttribute("update", user);
                request.getRequestDispatcher("/view/UserView/UserUpdate.jsp").forward(request, response);
            }
            response.sendRedirect("user");
            return;
        }

        if (URI.contains("/user/add")) {
            Boolean onclick = true;
            User user = new User();
            user.setId(request.getParameter("id"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setFullname(request.getParameter("fullname"));
            user.setAdmin(request.getParameter("admin") != null);
            if (check(request, response, user)) {
                onclick = true;
                request.setAttribute("click", onclick);
                userService.add(user);
            } else {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/view/UserView/UserAdd.jsp").forward(request, response);
            }
        }
        response.sendRedirect("user");
    }


    private Boolean checkTrongUD(String email, String fullname, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        if (email.isEmpty()) {
            count++;
            req.setAttribute("tEmail", "Không được trống email");

        }
        if (fullname.isEmpty()) {
            count++;
            req.setAttribute("tFullName", "Không được trống fullName");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean checkTrungEmail(String email, User u, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> listTam = userService.getAll();
        int count = 0;
        if (u.getEmail().equalsIgnoreCase(email)) {
        } else {
            for (User u2 : userService.getAll()) {
                if (u2.getEmail().equalsIgnoreCase(email)) {
                    count++;
                }
            }
        }

        if (count == 0) {
            return true;
        } else {
            req.setAttribute("trEmail", "Đã trùng email");
            return false;
        }

    }

    private Boolean check(HttpServletRequest request, HttpServletResponse response, User u) throws ServletException, IOException {
        int count = 0;
        int countTrungID = 0;
        int countTrungEmail = 0;
        if (u.getId().trim().isEmpty()) {
            count++;
            request.setAttribute("tID", "Không được trống id");
        } else {
            for (User user : userService.getAll()) {
                if (user.getId().equalsIgnoreCase(u.getId())) {
                    count++;
                    countTrungID++;
                }
            }
            if (countTrungID > 0) {
                request.setAttribute("trID", "Đã trùng id");
            }
        }
        if (u.getPassword().trim().isEmpty()) {
            count++;
            request.setAttribute("tPass", "Không được trống Password");
        } else {
            if (u.getPassword().length() < 6) {
                request.setAttribute("lPass", "Phải có ít nhất 6 ký tự");
            }
            if (!u.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d).+$")) {
                request.setAttribute("csPass", "Chứa ít nhất một chữ cái và một chữ số");
            }
        }
        if (u.getEmail().trim().isEmpty()) {
            count++;
            request.setAttribute("tEmail", "Không được trống Email");
        } else {
            for (User user : userService.getAll()) {
                if (user.getEmail().equalsIgnoreCase(u.getEmail())) {
                    count++;
                    countTrungEmail++;
                }
            }
            if (countTrungEmail > 0) {
                request.setAttribute("trEmail", "Đã trùng Email");
            }
        }
        if (u.getFullname().trim().isEmpty()) {
            count++;
            request.setAttribute("tFullName", "Không được trống Fullname");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
