<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/31/2024
  Time: 1:00 AM
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
    <h2>Danh sách sinh viên</h2>
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ma">
        </div>
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ten">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Ngày sinh</label>
            <input type="date" class="form-control" id="exampleInputPassword1" name="ngaysinh">
        </div>
        <div class="mb-3">
            <label class="form-label">Giới tính</label>
            <div class="form-check">

                <input class="form-check-input" type="radio" name="gioitinh" value="true">
                <label class="form-check-label">
                    Nam
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="gioitinh" checked value="false">
                <label class="form-check-label">
                    Nữ
                </label>
            </div>
        </div>

        <div class="mb-3">

            <select class="form-select" aria-label="Default select example" name="nganhhoc">
                <option selected>Ngành học</option>
                <option value="Công nghệ thông tin">Công nghệ thông tin</option>
                <option value="Kinh tế">Kinh tế</option>
                <option value="Kỹ thuật cơ khí">Kỹ thuật cơ khí</option>
                <option value="Luật">Luật</option>
                <option value="Y học">Y học</option>
                <option value="Quản trị kinh doanh">Quản trị kinh doanh</option>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-check-label">Trạng thái</label>
            <input type="checkbox" class="form-check-input" name="trangthai">

        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
    <table class="table table-bordered" >
        <tr>
            <th>#</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Ngành học</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${list}" var="l" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>${l.ngaysinh}</td>
                <td>${l.gioitinh?"Nam":"Nữ"}</td>
                <td>${l.nganhhoc}</td>
                <td>${l.trangthai?"Qua":"Trượt"}</td>
                <td>
                    <a href="/updateSV?id=${l.id}"><button type="submit" class="btn btn-warning">Update</button></a>
                    <a href="/deleteSV?id=${l.id}"><button type="submit" class="btn btn-danger">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
