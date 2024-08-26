<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/5/2024
  Time: 10:13 AM
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
    <h2>Thông tin nhân viên</h2>
    <form method="post">
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Mã</label>
            <input type="text" class="form-control" value="${nv.ma}" name="password"
                   id="exampleInputPassword1">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail11" class="form-label">Tên</label>
            <input type="text" class="form-control" name="email" value="${nv.ten}" id="exampleInputEmail11"
                   aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail11" class="form-label">Giới tính</label>
            <div class="form-check">

                <input class="form-check-input" type="radio" ${nv.gioitinh=="Nam"?"checked":""} name="gioiTinh"
                       value="true" id="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" ${nv.gioitinh == "Nữ"?"checked":""} name="gioiTinh"
                       value="false" id="flexRadioDefault2"
                >
                <label class="form-check-label" for="flexRadioDefault2">
                    Nữ
                </label>
            </div>
        </div>
        <div class="mb-3">
            <label for="fullName" class="form-label">Địa chỉ</label>
            <input type="text" class="form-control" name="" value="${nv.diachi}" id="fullName"
                   aria-describedby="emailHelp">

        </div>
    </form>
</div>

</body>
</html>
