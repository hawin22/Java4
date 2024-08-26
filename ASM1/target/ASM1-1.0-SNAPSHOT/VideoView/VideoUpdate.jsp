<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 7/21/2024
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Title</title>
</head>
<style>
    span{
        color: red;
    }
</style>
<body>
<div class="container">
    <form action="/updateVD" method="post">
        <div class="mb-3">
            <label class="form-label">Title</label>
            <input type="text" class="form-control" name="title" value="${updateVD.getTitle()}" >
            <span>${tTitle}</span>
        </div>
        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea name="description" class="form-control" cols="30" rows="3">${updateVD.getDescription()}</textarea>
            <span>${tDescription}</span>
        </div>
        <div class="mb-3">
            <label class="form-check-label">Active: </label>
            <input type="checkbox" name="active" class="form-check-input" id="exampleCheck1" ${updateVD.getActive() ? "checked" : ""}>
        </div>
        <div class="mb-3">
            <label  class="form-label">Poster</label>
            <input type="text" class="form-control" name="poster" value="${updateVD.getPoster()}" >
            <span>${tPoster}</span>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
