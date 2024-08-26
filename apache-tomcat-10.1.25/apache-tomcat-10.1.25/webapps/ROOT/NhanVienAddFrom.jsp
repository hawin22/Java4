<%--
  Created by IntelliJ IDEA.
  User: Lenh
  Date: 8/8/2024
  Time: 4:49 PM
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
    <form action="/nhan-vien/add" method="post">

        <div class="mb-3">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" required>
        </div>
        <div class="mb-3">
            <label for="ten" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="ten" required>
        </div>
        <div class="mb-3">
            <label for="gioiTinh" class="form-label">GioiTinh</label>
            <input type="text" class="form-control" id="gioiTinh" name="gioiTinh" required>
        </div>

        <div class="mb-3">
            <label for="diaChi" class="form-label">Địachỉ</label>
            <input type="text" class="form-control" id="diaChi" name="diaChi" required>
        </div>

        <button type="submit" class="btn btn-primary">ADD</button>
    </form>

</div>
</body>
</html>
