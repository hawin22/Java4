<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/9/2024
  Time: 11:10 PM
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
        <div class="alert alert-success">${mssg}</div>
    </c:if>
    <h2 class="center">
        Quản lý bạn bè
    </h2>
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ma" value="${update.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ten" value="${update.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Sở thích</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="sothich" value="${update.sothich}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioitinh" value="1" ${update.gioitinh==1?"checked":""}>
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioitinh" value="0" ${update.gioitinh==0?"checked":""}>
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label class="form-label">Mã MQH</label>
            <select name="mqh" class="form-select" aria-label="Default select example">
                <option selected hidden value="${update.mqh.id}"> ${update.mqh.ma}</option>
                <c:forEach items="${listMQH}" var="l">
                    <option value="${l.id}">${l.ma}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <table class="table table-bordered">
        <tr>
            <th>STT</th>
            <th>Mã bạn</th>
            <th>Tên bạn</th>
            <th>Sở thích</th>
            <th>Giới tính</th>
            <th>Mã MQH</th>
            <th>Tên MQH</th>
            <th>Hành động</th>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>${l.sothich}</td>
                <td>${l.gioitinh==1?"Nam":"Nữ"}</td>
                <td>${l.mqh.ma}</td>
                <td>${l.mqh.ten}</td>
                <td>
                    <a href="/ban/update?id=${l.id}"><button class="btn btn-warning" type="submit">Update</button></a>
                    <a href="/ban/delete?id=${l.id}"><button class="btn btn-danger" type="submit" onclick="return confirm('Bạn có muốn xoá không??')">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <c:forEach begin="1" end="${sumPage}" var="i">
            <a href="/ban/hien-thi?page=${i}">
                <button type="submit">${i}</button></a>
        </c:forEach>
    </div>
</div>
</body>
</html>
