<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/12/2024
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="post">
    <p>Họ tên: <input type="text" name="fullname"></p>
    <p>Ngày sinh: <input type="text" name="birthday"></p>
    <p>Quốc tịch: </p>
    <select name="country" id="">
        <option value="">----</option>
        <option value="Việt Nam">Việt Nam</option>
        <option value="Mỹ">Mỹ</option>
        <option value="Úc">Úc</option>
    </select>
    <p>Giới tính:
        <input type="radio" name="gender" value="true">Nam
        <input type="radio" name="gender" value="false">Nữ
    </p>
    <p>Tình trạng hôn nhân: <input type="checkbox" name="married"></p>
    <button type="submit">Thêm mới</button>
</form>