<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/21/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<style>
    span{
        color: red;
    }
</style>
<body>
<div class="container">
    <form action="/user/add" method="post">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="id" value="${user.id}">
            <span>${tID}</span>
            <span>${trID}</span>
        </div>
        <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" value="${user.password}" >
            <span>${tPass}</span>
            <span>${lPass}</span><br>
            <span>${csPass}</span>
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail11" class="form-label">Email</label>
            <input type="email" class="form-control" id="exampleInputEmail11" aria-describedby="emailHelp" name="email" value="${user.email}">
            <span>${tEmail}</span>
            <span>${trEmail}</span>
        </div>
        <div class="mb-3">
            <label for="fullName" class="form-label">Fullname</label>
            <input type="text" class="form-control" id="fullName" aria-describedby="emailHelp" name="fullname" value="${user.fullname}">
            <span>${tFullName}</span>
        </div>
        <div class="mb-3">
            <label class="form-check-label">Admin: </label>
            <input type="checkbox" name="admin" class="form-check-input" id="exampleCheck1" ${user.admin ? "checked" : ""}>
        </div>
        <button type="submit" onclick="${click?"return confirm('Bạn có muốn thêm không?')":""}" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
