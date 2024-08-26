<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 2:04 AM
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
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="c">
            <tr>
                <td>${c.count}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>${l.gioitinh}</td>
                <td>${l.diachi}</td>
                <td>
                    <a href=""><button type="submit" class="btn btn-success">Detail</button></a>
                    <a href=""><button type="submit" class="btn btn-warning">Update</button></a>
                    <a href=""><button type="submit" class="btn btn-danger">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
