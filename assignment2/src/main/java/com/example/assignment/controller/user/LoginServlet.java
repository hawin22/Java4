package com.example.assignment.controller.user;

//import com.example.assignment.ServiceFactory;
import com.example.assignment.service.UserService;
import com.example.assignment.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //    UserService service = ServiceFactory.getUserService();
    UserService ser = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, String> list = ser.HashMap();
        if (checkTrong(username, password, req, resp)) {
            if (list.containsKey(username) && list.get(username).equals(password)) {
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("home");
                return;
            } else {
                req.setAttribute("err", "Tài khoản hoặc mật khẩu không đúng");
            }
        }

//        if(service.checkUser(username, password)){
//            req.getSession().setAttribute("username", username);
//            resp.sendRedirect("home");
//            return;
//        }
//        req.setAttribute("message", "Incorrect username/password");
        req.getRequestDispatcher("/view/account/login.jsp").forward(req, resp);
    }

    protected boolean checkTrong(String username, String password, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = 0;
        if (username.trim().isEmpty() || username.trim() == null) {
            count++;
            req.setAttribute("trUserName", "Trống username rùi á :(((");
        }
        if (password.trim().isEmpty() || password.trim() == null) {
            count++;
            req.setAttribute("trPassword", "Trống password rùi á :(((");
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
