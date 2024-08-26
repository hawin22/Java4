<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        form{
            text-align: center;
            margin-top: 15px;
        }
        button{
            background: chocolate;
            color: white;
            width: 100px;
            height: 35px;
            border: 1px solid chocolate;
            font-size: 25px;

        }
        form{
            font-size: 25px;
        }
        form>input{
            height: 30px;
        }
    </style>
</head>
<body>
<form action="login" method="post" style="">
    Username: <input type="text" name="username" >
    Password: <input type="password" name="password">
    <button>Login</button>
</form></body>
</html>