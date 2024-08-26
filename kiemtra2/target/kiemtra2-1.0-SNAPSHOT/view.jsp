<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/31/2024
  Time: 10:23 AM
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
    <h2>QUẢN LÝ SẢN PHẨM</h2>
    <form method="post">
        <div class="mb-3">

            <select class="form-select" aria-label="Default select example" name="nambh" >
                <option selected value="${sp.nambh}">${sp.nambh}</option>
                <option value="2000">2000</option>
                <option value="2001">2001</option>
                <option value="2002">2002</option>
                <option value="2003">2003</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng tồn</label>
            <input type="number" class="form-control" aria-describedby="emailHelp" name="soluongton" value="${sp.soluongton}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giá nhập</label>
            <input type="number" class="form-control" aria-describedby="emailHelp" name="gianhap" value="${sp.gianhap}">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mô tả</label>
            <input type="text" class="form-control" id="exampleInputPassword1" name="mota" value="${sp.mota}">
        </div>

        <button type="submit" class="btn btn-success">Update</button>
    </form>
    <table class="table table-bordered" >
        <tr>
            <th>STT</th>
            <th>Năm bảo hành</th>
            <th>Số lượng tồn</th>
            <th>Giá nhập</th>
            <th>Mô tả</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${l.nambh}</td>
                <td>${l.soluongton}</td>
                <td>${l.gianhap}</td>
                <td>${l.mota}</td>
                <td>
                    <a href="/san-pham/update?id=${l.id}"><button type="submit" class="btn btn-success">Detail</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
