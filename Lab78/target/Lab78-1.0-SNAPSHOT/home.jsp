<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/5/2024
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>QUẢN LÝ NHÂN VIÊN</h2>
    <c:if test="${not empty message}">

    <div>${message}</div>
    </c:if>
    <table class="table table-hover">
        <tr>
            <th>#</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="l" items="${list}" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>${l.gioitinh}</td>
                <td>${l.diachi}</td>
                <td><a href="/nhan-vien/detail?id=${l.id}">
                    <button class="btn btn-success">Detail</button>
                </a></td>
                <td><a href="/nhan-vien/delete?id=${l.id}">
                    <button onclick="return confirm('Bạn có muốn xoá không')"  class="btn btn-danger">Delete</button>
                </a></td>

            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>