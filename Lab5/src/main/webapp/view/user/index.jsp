<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/24/2024
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<body class="container">
<h3>User List</h3>
<form action="" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">ID</label>
        <input type="text" class="form-control" value="${currentUser.id}" id="exampleInputEmail1" aria-describedby="emailHelp" name="id">
    </div>
    <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="text" class="form-control" value="${currentUser.password}" name="password">
    </div>
    <div class="mb-3">
        <label class="form-check-label" for="exampleCheck1">Admin:</label>
        <input type="checkbox" class="form-check-input" id="exampleCheck1" ${currentUser.admin?"checked":""} name="admin">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<table class="table table-bordered">
    <tr>
        <th>ID</th>
        <th>Password</th>
        <th>Role</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.password}</td>
            <td>${l.admin?"Admin":"User"}</td>
            <td><a href="delete-user?id=${l.id}">
                <button type="submit" class="btn btn-danger">Delete</button>
            </a><a href="update-user?id=${l.id}">
                <button type="submit" class="btn btn-warning">Update</button>
            </a>
        </tr>
    </c:forEach>
</table>


</body>
</html>
