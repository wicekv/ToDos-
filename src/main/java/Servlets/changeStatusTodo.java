package Servlets;

import DataBase.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "changeStatusTodo", value = "/changeStatusTodo")
public class changeStatusTodo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String is_done = request.getParameter("is_done");
        String sql0 = "UPDATE todos SET todos.is_done=1 WHERE todos.id=" + id;
        String sql1 = "UPDATE todos SET todos.is_done=0 WHERE todos.id=" + id;

        try {
            Connection connection = DBConnection.getConnectionDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            System.out.println(is_done);
            if(is_done.equals("0")) {
                System.out.println(id);
                DBConnection.executeDML(sql0);
            } else {
                DBConnection.executeDML(sql1);
            }
            request.getRequestDispatcher("showTodos.jsp").forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
