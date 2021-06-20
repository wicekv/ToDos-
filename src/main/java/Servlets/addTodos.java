package Servlets;

import DataBase.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "addTodos", value = "/addTodos")
public class addTodos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("");
        String description = request.getParameter("");
        String is_done = request.getParameter("");


        try {
            Connection connection = DBConnection.getConnectionDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql =
                "INSERT INTO todos(title, description, is_done) " +
                        "VALUES('" + title + "','" + description + "','" + is_done + "')";

    }
}
