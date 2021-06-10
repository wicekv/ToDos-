<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 09.06.2021
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="register.css">
    <title>Registration</title>
</head>
<body>

<div class="main">
<ul>
    <li><a href="index.jsp">Strona Główna</a></li>
    <li style="float:right"><a  href="Login.jsp">Logowanie</a></li>
    <li style="float:right"><a  href="Register.jsp">Rejestracja</a></li>
</ul>
<img src="assets/coin.jpg" alt="" class="background_image">
    <div class="register_form">
    <form action="Register" method="post">
        <label for="login">Nazwa użytkownika</label>
        <input type="text" id="login" name="username">
        <div class="form_border"></div>

        <label for="email">Email</label>
        <input type="email" id="email" name="email">
        <div class="form_border"></div>

        <label for="password">HASŁO</label>
        <input type="password" id="password" name="password">
        <div class="form_border"></div>

        <input type="submit" value="Zarejestruj">
    </form>
    <div class="column_nav">
        <a class="register">Zaloguj się</a>
        <a class="forgot_password">Przypomnij hasło</a>
    </div>
</div>
</div>

</body>
</html>
