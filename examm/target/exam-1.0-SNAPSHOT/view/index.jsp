<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 5:00 PM
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
    <c:if test="${not empty msg}">
        <div class="alert alert-success">
            ${msg}
        </div>
    </c:if>
    <div>
        <a href="/PhieuGiamGia/hien-thi?show=true">
            <button type="submit" class="btn btn-primary">Hiển thị</button>
        </a>
        <a href="/PhieuGiamGia/view-add">
            <button type="submit" class="btn btn-success">ADD</button>
        </a>
    </div>
    <h2>Quản lý phiếu giảm giá</h2>
    <c:if test="${view==true}">
        <table class="table table-bordered">
            <tr>
                <th>STT</th>
                <th>Tên</th>
                <th>Số lượng</th>
                <th>Loại giảm</th>
                <th>Giá trị tối đa</th>
                <th>Mã phiếu</th>
                <th>Tên phiếu</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="l" varStatus="c">
                <tr>
                    <td>${c.count}</td>
                    <td>${l.ten}</td>
                    <td>${l.soluong}</td>
                    <td>${l.loaigiam}</td>
                    <td>${l.giatritoida}</td>
                    <td>${l.loaiPhieu.ma}</td>
                    <td>${l.loaiPhieu.ten}</td>
                    <td>
                        <a href="/PhieuGiamGia/detail?id=${l.id}"><button type="submit" class="btn btn-success">Detail</button></a>
                        <a href="/PhieuGiamGia/view-update?id=${l.id}"><button type="submit" class="btn btn-warning">Update</button></a>
                        <a href="/PhieuGiamGia/delete?id=${l.id}"><button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá không')">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div>
            <c:forEach begin="1" end="${tongSoTrang}" var="i">
                <a href="/PhieuGiamGia/hien-thi?show=true&page=${i}">${i}</a>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
