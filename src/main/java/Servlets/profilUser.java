package Servlets;

import DataBase.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "profilUser", value = "/profilUser")
public class profilUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = (String) request.getSession().getAttribute("username");
        String email = (String) request.getSession().getAttribute("email");

        try {
            Connection connection = DBConnection.getConnectionDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "SELECT name, email FROM users WHERE users.name=\""+name + "\"";

        try {
            DBConnection.executeDML(sql);
            System.out.println(sql);
            request.getRequestDispatcher("profil.jsp").forward(request, response);
        } catch (SQLException throwables) {
            System.err.println("Błąd polecenia " + sql);

            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = (String) request.getSession().getAttribute("username");

        String sql = "UPDATE users SET users.email = \""+email + "\" WHERE users.name=\""+name + "\"";

        try {
            Connection connection = DBConnection.getConnectionDB();
            DBConnection.executeDML(sql);
            System.out.println(sql);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException throwables) {
            System.err.println("Błąd polecenia " + sql);
            throwables.printStackTrace();
        }

    }
}
