<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/15/2024
  Time: 4:10 PM
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
    <h1>List videos</h1> <br>
    <c:if test="${listvd == 0}">
        <h2>List trống</h2>
    </c:if>
    <c:if test="${listvd!=0}">
        <table class="table table-bordered">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Active</th>
                <th>Poster</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listVD}" var="l">
                <tr>
                    <td>${l.getId()}</td>
                    <td>${l.getTitle()}</td>
                    <td>${l.getDescription()}</td>
                    <td>${l.getActive()?"Yes":"No"}</td>
                    <td><img src="${l.getPoster()}" style="width: 300px; height: auto" alt="">
                            <%--                        <iframe src="${l.getPoster()}" frameborder="0"></iframe>--%>
                    </td>
                    <td><a href="/video/updateVD?id=${l.getId()}"><button type= "button" class="btn btn-warning " >Update</button></a>
                        <a href="/video/deleteVD?id=${l.getId()}"><button type="button" style="margin-top: 20px; width: 75px" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá không ????')">Delete</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="video/addVD"><button type="button" class="btn btn-success">Add Video</button></a>
</div>
</body>
</html>
