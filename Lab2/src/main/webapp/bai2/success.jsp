<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/8/2024
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">

</head>
<body>

<p>Username: ${username}</p>
<p>Password: ${pass}</p>
<p>Gender: ${gender}</p>
<p>Status: ${status}</p>
<p>Country: ${country}</p>
<p>Notes: ${note}</p>
<p>Sở thích: </p>
<ul>
    <%
        String[] mang = (String[]) request.getAttribute("hobbies");
        if (mang != null) {
            for (int i = 0; i < mang.length; i++) {
    %>
    <%= mang[i]
    %>
    <% if (i < mang.length - 1) {%>
    <%= ","%>
    <%
            }
        }
    } else {
    %>
    <li>No hobbies selected</li>
    <%
        }
    %>
</ul>

</body>
</html>
