package Authorization;

import DataBase.DBConnection;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public static String getUserId(String username, String password){
        String sql = "SELECT id, name, password FROM users";
        String id = "";
        try{
            Connection connection = DBConnection.getConnectionDB();
            ResultSet rs = DBConnection.getData(sql);

            while(rs.next()){
                if(rs.getString("name").equals(username) && rs.getString("password").equals(password)){
                    id = rs.getString("id");
                }
            }
            return id;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    public static boolean isAuth(String username, String password){
        String sql = "SELECT name, password FROM users";

        try{
            Connection connection = DBConnection.getConnectionDB();
            ResultSet rs = DBConnection.getData(sql);

            while(rs.next()){
                if(rs.getString("name").equals(username) && rs.getString("password").equals(password)){
                    return true;
                }
            }
            return false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }


}
