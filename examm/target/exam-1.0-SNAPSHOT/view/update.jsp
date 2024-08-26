<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 5:36 PM
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
    <form method="post" action="/PhieuGiamGia/update?id=${pgg.id}">
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" name="ten" aria-describedby="emailHelp" value="${pgg.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng</label>
            <input type="number" class="form-control" name="soluong" aria-describedby="emailHelp"
                   value="${pgg.soluong}">
        </div>
        <div class="mb-3">
            <label class="form-label">Loại giảm</label>
            <input type="text" class="form-control" name="loaigiam" aria-describedby="emailHelp"
                   value="${pgg.loaigiam}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giá trị tối đa</label>
            <select name="giatritoida" class="form-select" aria-label="Default select example">
                <option selected hidden value="${pgg.giatritoida}">${pgg.giatritoida}</option>
                <option value="NmzjrdngRS">NmzjrdngRS</option>
                <option value="DOsiHfptDR">DOsiHfptDR</option>
                <option value="NGZIIl8Vg5">NGZIIl8Vg5</option>
                <option value="bTCmKR2LDj">bTCmKR2LDj</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Loại phiếu</label>
            <select name="idlp" class="form-select" aria-label="Default select example">
                <option selected hidden value="${pgg.loaiPhieu.id}">${pgg.loaiPhieu.ma}</option>
                <c:forEach items="${listLP}" var="l">
                <option value="${l.id}">${l.ma}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
