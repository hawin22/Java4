<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 5:31 PM
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
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" value="${pgg.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Số lượng</label>
            <input type="number" class="form-control" aria-describedby="emailHelp" value="${pgg.soluong}">
        </div>
        <div class="mb-3">
            <label class="form-label">Loại giảm</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" value="${pgg.loaigiam}">
        </div>
        <div class="mb-3">
            <label class="form-label">Giá trị tối đa</label>
            <select class="form-select" aria-label="Default select example">
                <option selected hidden value="${pgg.giatritoida}">${pgg.giatritoida}</option>
            </select>
        </div><div class="mb-3">
            <label class="form-label">Mã phiếu</label>
            <select class="form-select" aria-label="Default select example">
                <option selected hidden value="${pgg.loaiPhieu.id}">${pgg.loaiPhieu.ma}</option>
            </select>
        </div>
    </form>
</div>
</body>
</html>
