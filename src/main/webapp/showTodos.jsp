<%@ page import="java.sql.Connection" %>
<%@ page import="DataBase.DBConnection" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Danny
  Date: 19.06.2021
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pokaż notatki</title>
    <link rel="stylesheet" href="stylee/style.css">

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
    </ul>
    <img src="assets/coin.jpg" alt="" class="background_image">

    <div style="background-color: white">
        <%
            try {
                String sql = "SELECT * FROM todos WHERE user_id = " + request.getSession(false).getAttribute("user_id");
                Connection connection = DBConnection.getConnectionDB();
                ResultSet resultSet = DBConnection.getData(sql);
        %>
        <table border=1 style="text-align:center">
            <thead>
            <tr>
                <th>Tytuł</th>
                <th>Opis</th>

            </tr>
            </thead>
            <tbody>
            <%
                while (resultSet.next()) {
            %>
            <tr>
                <td><%=resultSet.getString("title") %>
                </td>
                <td><%=resultSet.getString("description") %>
                </td>
                <td><%=resultSet.getString("is_done") %>
                </td>
                <td>
                    <form action="deleteTodo" method="post">
                        <input type="hidden" id="id" name="id" value=<%=resultSet.getString("id") %>>
                        <input type="submit" value="Usuń">
                    </form>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
        <br>
        <%
        } catch (Exception e) {
            e.printStackTrace();
        %><br><%
        }%>
    </div>
</div>
</body>
</html>
