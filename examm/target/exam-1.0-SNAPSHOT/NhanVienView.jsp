<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenh
  Date: 8/8/2024
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <a href="/nhan-vien/view-add">
        <button class="btn btn-primary">ADD</button>
    </a>
    <c:if test="${not empty message}">
        <div class="alert alert-success">${message}</div>
    </c:if>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Mã</th>
            <th scope="col">Tên</th>
            <th scope="col">gioiTinh</th>
            <th scope="col">diaChi</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nv" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${nv.ma}</td>
                <td>${nv.ten}</td>
                <td>${nv.gioiTinh}</td>
                <td>${nv.diaChi}</td>
                <td>
                    <a href="/nhan-vien/detail?id=${nv.id}">
                        <button class="btn btn-warning">Deatil</button>
                    </a>

                    <a href="/nhan-vien/delete?id=${nv.id}" onclick="return confirm('Bạn có muốn xoá không')">
                        <button class="btn btn-danger">Delete</button>
                    </a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

</div>


</body>
</html>
