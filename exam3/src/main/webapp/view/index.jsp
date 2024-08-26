<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 8/13/2024
  Time: 10:58 PM
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
    <a href="/hien-thi?show=${view==true?false:true}">
        <button type="submit" class="btn btn-primary">Hiển thị</button>
    </a>
    <c:if test="${not empty msg}">
        <div class="alert alert-success">
                ${msg}
        </div>
    </c:if>
    <h2>Quản lý hoá đơn</h2>
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Mã</label>
            <input type="text" class="form-control" aria-describedby="emailHelp" name="ma" value="${hd.ma}">
            <p>${trMa}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày tạo</label>
            <input type="date" class="form-control" aria-describedby="emailHelp" name="ngaytao" value="${hd.ngaytao}">
            <p>${trngayTao}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày thanh toán</label>
            <input type="date" class="form-control" aria-describedby="emailHelp" name="ngaythanhtoan" value="${hd.ngaythanhtoan}">
            <p>${trngayThanhToan}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày ship</label>
            <input type="date" class="form-control" aria-describedby="emailHelp" name="ngayship" value="${hd.ngayship}">
            <p>${trngayShip}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Ngày nhận</label>
            <input type="date" class="form-control" aria-describedby="emailHelp" name="ngaynhan" value="${hd.ngaynhan}">
            <p>${trngayNhan}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Tình trạng</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tinhtrang" value="0" ${hd.tinhtrang==0?"checked":""}>
                <label class="form-check-label">
                    Chưa thanh toán
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="tinhtrang" value="1" ${hd.tinhtrang==1?"checked":""}>
                <label class="form-check-label">
                    Đã thanh toán
                </label>
            </div>
            <p>${trtinhTrang}</p>
        </div>
        <div class="mb-3">
            <label class="form-label">Mã nhân viên</label>
            <select name="idnv" class="form-select" aria-label="Default select example">
                <option selected hidden value="${hd.nhanVien.id}">${hd.nhanVien.ma}</option>
                <c:forEach items="${listNV}" var="l">
                <option value="${l.id}">${l.ma}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <c:if test="${view==true}">
        <table class="table table-bordered">
            <tr>
                <th>STT</th>
                <th>Mã</th>
                <th>Ngày tạo</th>
                <th>Ngày thanh toán</th>
                <th>Ngày ship</th>
                <th>Ngày nhận</th>
                <th>Tình trạng</th>
                <th>Mã nhân viên</th>
                <th>Tên nhân viên</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="l" varStatus="c">
                <tr onclick="location.href='detail?id=${l.id}&show=true'">
                    <td>${c.count}</td>
                    <td>${l.ma}</td>
                    <td>${l.ngaytao}</td>
                    <td>${l.ngaythanhtoan}</td>
                    <td>${l.ngayship}</td>
                    <td>${l.ngaynhan}</td>
                    <td>${l.tinhtrang==1?"Đã thanh toán":"Chưa thanh toán"}</td>
                    <td>${l.nhanVien.ma}</td>
                    <td>${l.nhanVien.ten}</td>
                    <td>
                        <a href="/detail?id=${l.id}&show=true"><button type="submit" class="btn btn-primary">Detail</button></a>
                        <a href="/update?id=${l.id}&show=true"><button type="submit" class="btn btn-warning">Update</button></a>
                        <a href="/delete?id=${l.id}"><button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá không??')">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach begin="1" end="${tongSoTrang}" var="i">
            <a href="/hien-thi?show=true&page=${i}">${i}</a>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
