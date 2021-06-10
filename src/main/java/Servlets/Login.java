package Servlets;

import Authorization.User;
import DataBase.DBConnection;

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");

       if(User.isAuth(username, password)){
           HttpSession session = request.getSession();
           session.setAttribute("username", username);
           request.getRequestDispatcher("homePage.jsp").forward(request, response);
       }else
       {
           request.setAttribute("blad", "Niepoprawne dane logowania!");
           request.getRequestDispatcher("Login.jsp").forward(request,response);
       }
    }
}
