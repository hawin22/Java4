<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/29/2024
  Time: 11:01 AM
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
    <h2>UPDATE KHÁCH HÀNG</h2>
    <form method="post" action="/khach-hang/update?id=${kh.id}">
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ten" value="${kh.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">SĐT</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="sdt" value="${kh.sdt}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" aria-describedby="emailHelp" name="ngaysinh" value="${kh.ngaysinh}">
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="matkhau" value="${kh.matkhau}">
        </div>
        <div class="mb-3">
            <label class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="diachi" value="${kh.diachi}">
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
