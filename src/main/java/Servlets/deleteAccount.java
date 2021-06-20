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
        String userId = (String) request.getSession().getAttribute("user_id");

        try {
            Connection connection = DBConnection.getConnectionDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sqlDelUser = "DELETE FROM users WHERE users.name=\""+name + "\"";
        String sqlDelUsersTodos = "DELETE FROM todos WHERE user_id=" + userId;

        try {
            DBConnection.executeDML(sqlDelUsersTodos);
            DBConnection.executeDML(sqlDelUser);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
