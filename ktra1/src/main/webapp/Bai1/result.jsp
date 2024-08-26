<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/10/2024
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="post">
<h2>Chi tiết hoá đơn</h2>
<p>Đơn giá: <input type="number" name="donGia" value="${param.donGia}"></p>
<p>Số lượng: <input type="number" name="soLuong" value="${param.soLuong}"></p>
<p>Thuế(%): <input type="number" name="thue" value="${param.thue}"></p>
    <button type="submit">Tổng tiền</button>   ${tinhTien}
</form>
