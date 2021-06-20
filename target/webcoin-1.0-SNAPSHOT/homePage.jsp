
<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 09.06.2021
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Strona główna</title>
    <link rel="stylesheet" href="stylee/style.css">
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
</div>
</body>
</html>
