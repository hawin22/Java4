package com.example.slide7;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/admin/*")
public class AuthFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if(req.getRequestURI().contains("/admin")){
            User user = (User) req.getSession().getAttribute("user");
            if(user == null || !user.getAdmin()){
                res.sendRedirect("/slide7_war_exploded/login");
            }else{
                chain.doFilter(req, res);
            }
        }
    }
}
