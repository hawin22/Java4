<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/10/2024
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="post">
    <h2>Thông tin máy tính</h2>
    <p>Mã: <input type="text" name="ma"></p>
    <p>Tên: <input type="text" name="ten"></p>
    <p>Giá: <input type="number" name="gia"></p>
    <p>Hãng:
        <select name="hang" id="">
            <option value="Acer">Acer</option>
            <option value="Dell">Dell</option>
            <option value="Lenovo">Lenovo</option>
        </select>
    </p>
    <p>Màu sắc:
        <input type="radio" name="mauSac" value="Đen">Đen
        <input type="radio" name="mauSac" value="Trắng">Trắng
        <input type="radio" name="mauSac" value=Bạc>Bạc
    </p>
    <p>Còn hàng: <input name="status" type="checkbox"></p>
    <button type="submit">Lưu lại</button>
</form>