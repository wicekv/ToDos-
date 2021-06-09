package Servlets;

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
            String sql = "insert into users(name,email,password) values(?,?,?)";

            String url = "jdbc:mysql://localhost/webcoin";

            Properties properties = new Properties();
            properties.setProperty("user","root");
            properties.setProperty("password","");

            try{
                Connection connection = DriverManager.getConnection(url,properties);
                System.out.println("Połączono z bazą danych WebCoin");
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);
                ps.executeUpdate();
                PrintWriter out = response.getWriter();
                out.println("Succesfully registered");

            }catch (SQLException e){
                e.printStackTrace();
            }

    }
}

