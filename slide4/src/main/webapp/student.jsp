<%@ page import="com.example.slide4.Students" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/15/2024
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul>
    <%
        List<Students> list = (List<Students>) request.getAttribute("list");
        for (Students st: list){
            response.getWriter().println("<li>"+st.getName()+"</li>");
        }
    %>

</ul>
