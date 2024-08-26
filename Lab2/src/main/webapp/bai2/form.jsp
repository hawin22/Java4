<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/8/2024
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Đăng ký</h3>
<form action="" method="post">
    <p>Tên đăng nhập: <input type="text" name="username"></p>
    <p>Mật khẩu: <input type="password" name="pass"></p>
    <p>Giới tính: <input type="radio" name="gender" value="true">Nam
        <input type="radio" name="gender" value="false">Nữ
    </p>
    <p><input type="checkbox" name="status">Đã có gia đình</p>
    <p>Sở thích:
        <input name="hobbies" value="Đọc sách" type="checkbox" >Đọc sách
        <input name="hobbies" value="Nghe nhạc" type="checkbox" >Nghe nhạc
        <input name="hobbies" value="Xem phim" type="checkbox" >Xem phim
    </p>
    <p>Quốc tịch:
        <select name="country" id="">
            <option value="VN">VN</option>
            <option value="US">US</option>
            <option value="UK">UK</option>
        </select>
    </p>
    <p>Ghi chú: <textarea name="note" id="" cols="30" rows="10"></textarea></p>
    <button type="submit">Đăng ký</button>
</form>