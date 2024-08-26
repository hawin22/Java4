<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 3:27 AM
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
    <form method="post" action="/nhan-vien/update?id=${nv.id}">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ma" value="${nv.ma}">
            <p>${trMa}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ten" value="${nv.ten}">
            <p>${trTen}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nam" ${nv.gioitinh=="Nam"?"checked":""} name="gioitinh" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" value="Nữ" name="gioitinh" ${nv.gioitinh=="Nữ"?"checked":""} id="flexRadioDefault2">
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
            <p>${trGt}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="diachi" value="${nv.diachi}">
            <p>${trDc}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Mã chức vụ</label>
            <select name="idcv" class="form-select" aria-label="Default select example">
                <option selected hidden value="${nv.chucVu.id}"> ${nv.chucVu.ma}</option>
                <c:forEach items="${listCV}" var="l">
                <option value="${l.id}"> ${l.ma}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary" onclick="return confirm('Bạn có muốn úp đết không')">Update</button>
    </form>

</div>

</body>
</html>
