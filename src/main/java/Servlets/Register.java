package Servlets;

import DataBase.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String name = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

             String sql = "INSERT INTO users(name,email,password) "+
                "VALUES('" + name + "','" + email + "','" + password + "')";

            try{
                Connection connection = DBConnection.getConnectionDB();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                    DBConnection.executeDML(sql);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
            }
    }
}

