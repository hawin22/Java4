<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="update?id=${banDetail.id}">
    <p>Mã: <input name="ma" value="${banDetail.ma}"></p>
    <p>Tên: <input name="ten" value="${banDetail.ten}"></p>
    <p>Sở thích: <input name="sothich" value="${banDetail.sothich}"></p>
    <p>Giới tính:
        <input type="radio" name="gioitinh" value="true" ${banDetail.gioitinh? "checked" : ""}> Nam
        <input type="radio" name="gioitinh" value="false" ${banDetail.gioitinh? "" : "checked"}> Nữ
    </p>
    <p>Mối quan hệ:
        <select name="moiquanhe">
            <option value="">----</option>
            <c:forEach items="${dsMQH}" var="m">
                <option value="${m.id}"
                    ${m.id == banDetail.moiQuanHe.id? "selected":""}
                >${m.ma}</option>
            </c:forEach>
        </select>
    </p>
    <button onclick="return confirm('Bạn có muốn update?')">Update</button>
</form>
<div><i>${msg}</i></div>
<table border="1">
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Sở thích</th>
        <th>Giới tính</th>
        <th>Mã MQH</th>
        <th>Tên MQH</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${list}" var="b" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.sothich}</td>
            <td>${b.gioitinh}</td>
            <td>${b.maMQH}</td>
            <td>${b.tenMQH}</td>
            <td>
                <a onclick="return confirm('Bạn có muốn xem chi tiết?')"
                   href="update?id=${b.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>