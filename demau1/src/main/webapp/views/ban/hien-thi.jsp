<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post">
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
                <option value="${m.id}">${m.ma}</option>
            </c:forEach>
        </select>
    </p>
    <button onclick="return confirm('Bạn có muốn thêm?')">Add</button>
</form>
<div><i>${msg}</i></div>
<form method="get" action="tim-kiem">
    <input name="keyword" value="${param.keyword}">
    <button>Tìm</button>
</form>
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
            <td>${st.count + offset}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.sothich}</td>
            <td>${b.gioitinh ? "Nam" : "Nữ"}</td>
            <td>${b.moiQuanHe.ma}</td>
            <td>${b.moiQuanHe.ten}</td>
            <td>
                <a onclick="return confirm('Bạn có muốn xem chi tiết?')"
                   href="detail?id=${b.id}">Detail</a>
            </td>
        </tr>
    </c:forEach>
</table>