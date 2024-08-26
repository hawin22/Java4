<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/31/2024
  Time: 2:38 AM
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
    <form method="post" action="/updateSV?id=${sv.id}">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ma" value="${sv.ma}">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ten"  value="${sv.ten}">
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" value="${sv.ngaysinh}" name="ngaysinh">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">

                <input class="form-check-input" type="radio" ${sv.gioitinh?"checked":""} value="true" name="gioitinh">
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" ${!sv.gioitinh?"checked":""} value="false" name="gioitinh">
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>

        <div class="mb-3">

            <select class="form-select" aria-label="Default select example" name="nganhhoc">
                <option selected value="${sv.nganhhoc}" hidden>${sv.nganhhoc}</option>
                <option value="Công nghệ thông tin">Công nghệ thông tin</option>
                <option value="Kinh tế">Kinh tế</option>
                <option value="Kỹ thuật cơ khí">Kỹ thuật cơ khí</option>
                <option value="Luật">Luật</option>
                <option value="Y học">Y học</option>
                <option value="Quản trị kinh doanh">Quản trị kinh doanh</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-check-label" for="exampleCheck1">Trạng thái</label>
            <input type="checkbox" name="trangthai" class="form-check-input" id="exampleCheck1" ${sv.trangthai?"checked":""}>

        </div>
        <button type="submit" formaction="updateSV" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
