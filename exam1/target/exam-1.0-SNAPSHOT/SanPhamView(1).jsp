<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenh
  Date: 8/7/2024
  Time: 10:13 PM
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
    <c:if test="${not empty message}">
      <div class="alert alert-success">${message}</div>
    </c:if>

    <form action="/san-pham/update" method="post">
        <input type="hidden" name="id" value="${sp.id}">
        <div class="mb-3">
            <label for="soLuong" class="form-label">SoLuong</label>
            <input type="text" value="${sp.soluong}" class="form-control" id="soLuong" name="soLuong" required>
        </div>

        <div class="mb-3">
            <label for="giaBan" class="form-label">GiaBan</label>
            <input type="text" value="${sp.giaban}" class="form-control" id="giaBan" name="giaBan" required>
        </div>

        <div class="mb-3">
            <label for="moTa" class="form-label">Mota</label>
            <input type="text" value="${sp.mota}" class="form-control" id="moTa" name="moTa" required>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>


    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">SoLuong</th>
            <th scope="col">GiaBan</th>
            <th scope="col">Mota</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="sp" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${sp.soluong}</td>
                <td>${sp.giaban}</td>
                <td>${sp.mota}</td>
                <td>
                    <a href="/san-pham/detail?id=${sp.id}">
                        <button class="btn btn-warning">Detail</button>
                    </a>

                    <a href="/san-pham/delete?id=${sp.id}" onclick="return confirm('Bạn có muốn xoá không?')">
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
