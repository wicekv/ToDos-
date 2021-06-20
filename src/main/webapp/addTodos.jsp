<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 19.06.2021
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj notatke</title>
    <link rel="stylesheet" href="stylee/style.css">
    <link rel="stylesheet" href="stylee/addTodos.css">
</head>
<body>
<%
    if(request.getSession(false).getAttribute("username") == null){
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
<h1>Witamy na stronie ${username}</h1>

<div class="main">
    <ul>
        <li><a href="addTodos.jsp">Dodaj notatke</a></li>
        <li><a href="addTodos.jsp">Lista notatek</a></li>
        <li style="float:right"><a href="profil.jsp">Profil uzytkownika</a></li>
        <li style="float:right"><a href="Logout">Wyloguj</a></li>
    </ul>
    <img src="assets/coin.jpg" alt="" class="background_image">

    <div class="add_form">
        <form action="Login" method="post">

            <label for="login">Tytuł notatki</label>
            <input type="text" id="login" name="username">
            <div class="form_border"></div>

            <label for="password">Opis notatki</label>
            <input type="password" id="password" name="password">

            <div class="form_border"></div>
            <input type="submit" value="Dodaj notatke">
        </form>
    </div>
    </div>
</body>
</html>
