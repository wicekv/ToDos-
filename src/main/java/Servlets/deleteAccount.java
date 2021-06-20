package Servlets;

import DataBase.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "deleteAccount", value = "/deleteAccount")
public class deleteAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = (String) request.getSession().getAttribute("username");

        try {
            Connection connection = DBConnection.getConnectionDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql = "DELETE FROM users WHERE users.name=\""+name + "\"";
        //String sql2 = "DELETE FROM todos WHERE todos.user_id = \""

        try {
            DBConnection.executeDML(sql);
            System.out.println(sql);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException throwables) {
            System.err.println("Błąd polecenia " + sql);

            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
