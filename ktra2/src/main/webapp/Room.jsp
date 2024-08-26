<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/19/2024
  Time: 10:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <h2>Quản lý Phòng</h2>
    <p>Số phòng: </p>
    <input type="text" name="soPhong">
    <p>Loại phòng</p>
    <input type="radio" name="loaiPhong" value="Thường">Thường
    <input type="radio" name="loaiPhong" value="VIP">VIP
    <p>Tầng:<select name="tang" id="">
        <option value="">1/2/3/4</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select></p>

    <p>Trạng thái: <input type="checkbox" name="trangThai" ></p>
    <button type="submit" class="btn btn-primary">Thêm</button>
</form>
    <ul>
        <table class="table">
            <tr>
                <th>Số phòng</th>
                <th>Loại phòng</th>
                <th>Tầng</th>
                <th>Trạng thái</th>
            </tr>
           <c:forEach items="${list}" var="l">
               <tr>
                   <td>${l.soPhong}</td>
                   <td>${l.loaiPhong}</td>
                   <td>${l.tang}</td>
                   <td>${l.trangThai?"Đang sử dụng":"Trống"}</td>
               </tr>
           </c:forEach>
        </table>
    </ul>
</body>
</html>
