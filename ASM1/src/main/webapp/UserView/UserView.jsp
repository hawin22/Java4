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
    <h1>List users</h1> <br>
   <c:if test="${r == 0}">
    <h2>List trống</h2>
   </c:if>
<c:if test="${r!=0}">
       <table class="table table-bordered">
           <tr>
               <th>ID</th>
               <th>Password</th>
               <th>Email</th>
               <th>Fullname</th>
               <th>Admin</th>
               <th>Action</th>
           </tr>
           <c:forEach items="${list}" var="l">
               <tr>
                   <td>${l.id}</td>
                   <td>${l.password}</td>
                   <td>${l.email}</td>
                   <td>${l.fullname}</td>
                   <td>${l.admin?"Yes":"No"}</td>
                   <td><a href="update?id=${l.id}"><button type="button" class="btn btn-warning">Update</button></a>
                       <a href="delete?id=${l.id}"><button type="button" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá không ????')">Delete</button></a></td>
               </tr>
           </c:forEach>
       </table>
</c:if>
    <a href="UserView/UserAdd.jsp"><button type="button" class="btn btn-success">Add User</button></a>
</div>
</body>
</html>
