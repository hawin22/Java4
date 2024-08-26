<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/29/2024
  Time: 10:13 AM
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
    <h2>QUẢN LÝ KHÁCH HÀNG</h2>
    <table class="table table-bordered">
        <tr>
            <th>#</th>
            <th>Tên</th>
            <th>SĐT</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Mật khẩu</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${l.ho} ${l.tendem} ${l.ten}</td>
                <td>${l.sdt}</td>
                <td>${l.ngaysinh}</td>
                <td>${l.diachi}</td>
                <td>${l.matkhau}</td>
                <td>
                    <a href="/khach-hang/view-update?id=${l.id}">
                        <button type="submit" class="btn btn-primary">Update</button>
                    </a>
                    <a href="/khach-hang/delete?id=${l.id}">
                        <button type="submit" class="btn btn-danger">Remove</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
