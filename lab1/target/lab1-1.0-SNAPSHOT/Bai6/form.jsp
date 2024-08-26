<%--
  Created by IntelliJ IDEA.
  User: Hawin
  Date: 6/28/2024
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <title>Bootstrap Example</title>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <form method="post">
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Chiều dài</label>
            <input type="number" class="form-control" aria-describedby="emailHelp" name="dai">
        </div>
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Chiều rộng</label>
            <input type="number" class="form-control" aria-describedby="emailHelp" name="rong">
        </div>
        <button type="submit" class="btn btn-primary">Tính</button>
    </form>
</div>
</body>
</html>
