<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/8/2024
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="" method="post">
    <p>Cạnh a: <input type="number" name="a" value="${param.a}"></p>
    <p>Cạnh b: <input type="number" name="b" value="${param.b}"></p>
    <p>Cạnh c: <input type="number" name="c" value="${param.c}"></p>
    <button type="submit" formaction="chuVi">Chu vi</button>  ${chuVi}
    <br>
    <button type="submit" formaction="dienTich">Dien tich</button>  ${dienTich}
</form>