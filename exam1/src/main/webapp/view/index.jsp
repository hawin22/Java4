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
    <c:if test="${not empty mssg}">
        <div class="alert alert-success">
                ${mssg}
        </div>
    </c:if>
    <h2>QUẢN LÝ NHÂN VIÊN</h2>
    <a href="/nhan-vien/hien-thi?show=true">
        <button type="submit" class="btn btn-primary">Hiển thị</button>
    </a>
    <a href="/nhan-vien/hien-thi?show=false">
        <button type="submit" class="btn btn-primary">Ẩn</button>
    </a>
    <a href="/nhan-vien/view-add">
        <button type="submit" class="btn btn-success">ADD</button>
    </a>
    <c:if test="${view==true}">
        <br>
        <table class="table table-bordered">
            <tr>
                <th>STT</th>
                <th>Mã</th>
                <th>Tên</th>
                <th>Giới tính</th>
                <th>Địa chỉ</th>
                <th>Mã chức vụ</th>
                <th>Tên chức vụ</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="l" varStatus="c">
                <tr onclick="location.href='/nhan-vien/detail?id=${l.id}'">
                    <td>${c.count}</td>
                    <td>${l.ma}</td>
                    <td>${l.ten}</td>
                    <td>${l.gioitinh}</td>
                    <td>${l.diachi}</td>
                    <td>${l.chucVu.ma}</td>
                    <td>${l.chucVu.ten}</td>
                    <td>
                        <a href="/nhan-vien/detail?id=${l.id}">
                            <button type="submit" class="btn btn-success">Detail</button>
                        </a>
                        <a href="/nhan-vien/view-update?id=${l.id}">
                            <button type="submit" class="btn btn-warning">Update</button>
                        </a>
                        <a href="/nhan-vien/delete?id=${l.id}">
                            <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá không')">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <c:forEach begin="1" end="${tongSoTrang}" var="p">
                <a href="/nhan-vien/hien-thi?show=true&page=${p}">${p}</a>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
