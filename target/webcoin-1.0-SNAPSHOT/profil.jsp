<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 19.06.2021
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profil</title>
    <link rel="stylesheet" href="stylee/style.css">
    <link rel="stylesheet" href="stylee/profil.css">
</head>
<body>
<%
    if (request.getSession(false).getAttribute("username") == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>

<div class="main">
    <ul>
        <li><a href="addTodos.jsp">Dodaj notatke</a></li>
        <li><a href="showTodos.jsp">Lista notatek</a></li>
        <li style="float:right"><a href="Logout">Wyloguj</a></li>
        <li style="float:right"><a href="profil.jsp">Profil uzytkownika</a></li>

    </ul>
    <img src="assets/img.png" alt="" class="background_image">

    <div class="profil_form">
        <form action="profilUser" method="post">
            <label for="username">Nazwa użytkownika</label>
            <input type="text" id="username" name="username" value="${username}">
            <div class="form_border"></div>

            <label for="email">Zmień Email</label>
            <input type="text" id="email" name="email" value="${email}">
            <div class="form_border"></div>
            <input type="submit" value="Zmien Email">
        </form>
    </div>

    <div class="profil_form" style="margin-top: 5px; top: 57%; height: auto; box-shadow: none; background: transparent">

        <form action="deleteAccount" method="get">
            <input type="submit" value="Usuń Konto" style="margin-top: 0">
        </form>
    </div>


    <%--    <div class="profil_form">--%>
    <%--        <form action="profilUser" method="post">--%>

    <%--            <label for="login">Nazwa użytkownika</label>--%>
    <%--            <input type="text" id="login" name="username" value="${username}">--%>
    <%--            <div class="form_border"></div>--%>

    <%--            <label for="login">Email</label>--%>
    <%--            <input type="text" id="email" name="email" value="${email}">--%>
    <%--            <div class="form_border"></div>--%>

    <%--            <label for="password">Hasło</label>--%>
    <%--            <input type="password" id="password" name="password" value="${password}">--%>
    <%--            <div class="form_border"></div>--%>

    <%--            <input type="submit" value="Zmien Dane">--%>
    <%--        </form>--%>
    <%--    </div>--%>
</div>
</body>
</html>
