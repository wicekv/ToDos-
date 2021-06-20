<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Strona główna</title>
    <link rel="stylesheet" href="stylee/style.css">

</head>
<body>
<div class="main">
    <ul>
        <li><a href="index.jsp">Strona Główna</a></li>
        <li style="float:right"><a  href="Login.jsp">Logowanie</a></li>
        <li style="float:right"><a  href="Register.jsp">Rejestracja</a></li>
    </ul>
    <img src="assets/img.png" alt="" class="background_image">

    <div class="container">
        <div class="inner">

            <h1>Dodaj swoją Notatke</h1>
            <p>pamiętaj o obowiązkach razem z nami</p>

            <button onClick="window.location.href='Register.jsp'" class="=btn btn-light">Dołącz do nas</button>
        </div>
    </div>
</div>
</body>
</html>
