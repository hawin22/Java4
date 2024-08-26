import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.User;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UserServlet", value = {"/user",
        "/add",
        "/update",
        "/delete"
})
public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    User userTrong = new User();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URI = request.getRequestURI();
        String id = request.getParameter("id");
        request.setAttribute("r", userService.getAll().size());
        if (URI.contains("/delete")) {
            userService.delete(id);
            response.sendRedirect("user");
            return;
        }
        if (URI.contains("/update")) {
            User user1 = userService.findID(id);
            request.setAttribute("update", user1);
            request.getRequestDispatcher("/UserView/UserUpdate.jsp").forward(request, response);
            userTrong = user1;
        }
        request.setAttribute("list", userService.getAll());
        request.getRequestDispatcher("/UserView/UserView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        Boolean admin = request.getParameter("admin") != null;
        User user = new User(id, password, email, fullname, admin);

        String URI = request.getRequestURI();
        if (URI.contains("/update")) {
            User user2 = new User(userTrong.getId(), userTrong.getPassword(), email, fullname, admin);
            if (checkTrongUD(email,fullname,request,response) && checkTrungEmail(email,userTrong,request,response)) {
                userService.update(user2);
                System.out.println(user2);
            } else {
                request.setAttribute("update", user2);
                request.getRequestDispatcher("/UserView/UserUpdate.jsp").forward(request, response);
            }
        }

        if (URI.contains("/add")) {
            if (check(request, response, user)) {
                userService.add(user);
            } else {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/UserView/UserAdd.jsp").forward(request, response);
            }
        }
        response.sendRedirect("user");
    }

//    private Boolean checkEmail(String email, HttpServletRequest req, HttpServletResponse resp, User u) throws ServletException, IOException {
//        if (email.isEmpty()) {
//            req.setAttribute("tEmail", "Không được trống email");
//            return true;
//        }
//        return false;
//    }
//
//    private Boolean checkTrungEmail(String email, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int count = 0;
//        for (User user : userService.listUser) {
//            if (user.getEmail().equalsIgnoreCase(email)) {
//                count++;
//            }
//        }
//        if (count == 0) {
//            return true;
//        } else {
//            System.out.println("Trung email update");
//            req.setAttribute("trEmail", "Trùng email");
//            return false;
//        }
//
//    }

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
    private Boolean checkTrungEmail(String email,User u ,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> listTam = userService.listUser;
        int count = 0;
        if (u.getEmail().equalsIgnoreCase(email)){
        }else {
            for (User u2 : userService.listUser){
                if (u2.getEmail().equalsIgnoreCase(email)){
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
        int countTrung = 0;
        if (u.getId().trim().isEmpty()) {
            count++;
            request.setAttribute("tID", "Không được trống id");
        } else {
            for (User user : userService.getAll()) {
                if (user.getId().equalsIgnoreCase(u.getId())) {
                    count++;
                    countTrung++;
                }
            }
            if (countTrung > 0) {
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
                    countTrung++;
                }
            }
            if (countTrung > 0) {
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
