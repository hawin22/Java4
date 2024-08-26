<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/15/2024
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul>
    <li>${list[0].id}</li>
    <li>${list[1].id}</li>
    <form action="" method="post">
        <p>ID: <input type="text" name="id" value="${currentUser.id}"></p>
        <p>password: <input type="password" name="password" value="${currentUser.password}"></p>
        <p>admin: <input type="checkbox" name="admin" ${currentUser.admin ? "checked" : ""}></p>
        <button type="submit">Save</button>
    </form>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Password</th>
            <th>Admin</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="u">

            <tr>
                <td>${u.id}</td>
                <td>${u.password}</td>
                <td>${u.admin}</td>
                <td><a href="delete-user?id=${u.id}">Delete</a></td>
                <td><a href="update-user?id=${u.id}">Update</a></td>
            </tr>

        </c:forEach>
    </table>
</ul>