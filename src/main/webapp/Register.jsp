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
    <link rel="stylesheet" href="stylee/style.css">
    <link rel="stylesheet" href="stylee/register.css">
    <title>Registration</title>
</head>
<body>

<div class="main">
<ul>
    <li><a href="index.jsp">Strona Główna</a></li>
    <li style="float:right"><a  href="Login.jsp">Logowanie</a></li>
    <li style="float:right"><a  href="Register.jsp">Rejestracja</a></li>
</ul>
    <img src="assets/img.png" alt="" class="background_image">
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
        <a href="Login.jsp" class="register">Zaloguj się</a>
    </div>
</div>
</div>

</body>
</html>
