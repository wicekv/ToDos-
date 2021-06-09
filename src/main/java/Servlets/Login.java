package Servlets;

import Authorization.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String name = request.getParameter("username");
            String password = request.getParameter("password");
            String dbName = null;
            String dbPassword = null;
            String sql = "SELECT * FROM users WHERE name=? and password=?";
            String url = "jdbc:mysql://localhost/webcoin";

            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "");

            Connection connection = DriverManager.getConnection(url,properties);

            System.out.println("Połączono z bazą danych WebCoin");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();


            while(resultSet.next()){
                dbName = resultSet.getString(2);
                dbPassword = resultSet.getString("password");
            }
            if(name.equals(dbName) && password.equals(dbPassword)){
                PrintWriter out = response.getWriter();
                out.println("Succesfully sign in");
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.include(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
