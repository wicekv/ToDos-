<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 09.06.2021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="stylee/style.css">
    <link rel="stylesheet" href="stylee/login.css">
</head>
<body>
<div class="main">
    <ul>
        <li><a href="index.jsp">Strona Główna</a></li>
        <li style="float:right"><a  href="Login.jsp">Logowanie</a></li>
        <li style="float:right"><a  href="Register.jsp">Rejestracja</a></li>
    </ul>
<img src="assets/coin.jpg" alt="" class="background_image">

    <div class="login_form">
        <form action="Login" method="post">

            <label for="login">LOGIN</label>
            <input type="text" id="login" name="username">
            <div class="form_border"></div>

            <label for="password">HASŁO</label>
            <input type="password" id="password" name="password">
            <div class="form_border"></div>

            <input type="submit" value="Zaloguj">
        </form>
        <div class="column_nav">
            <a class="register">Zarejestruj się</a>
            <a class="forgot_password">Przypomnij hasło</a>
        </div>
    </div>
</div>
</body>
</html>
