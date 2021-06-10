package DataBase;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnectionDB() throws SQLException {
        String url = "jdbc:mysql://localhost/webcoin";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","");

        try{
            connection = DriverManager.getConnection(url, properties);
            System.out.println("Pomyślnie połączono z bazą danych");
        }catch (SQLException e){
            System.out.println("Błąd podczas połączenia z bazą danych");
            e.printStackTrace();
            throw e;
        }
        return connection;
    }

    public static void disconnectDB() throws SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                connection = null;
                System.out.println("Zamknięto połączenie z bazą danych");
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Błąd podczas zamykania połączenia z bazą danych");
            throw e;
        }
    }

    public static void executeDML(String sql) throws SQLException{
        Statement statement = null;
        try {
            if(connection == null) throw new SQLException();
            statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Pomyślnie wykonano instrukcje SQL typu DML");
        } catch (SQLException e) {
            System.out.println("Błąd podczas wykonywania instrukcji SQL typu DML");
            e.printStackTrace();
            throw e;
        }
        finally {
            if(!statement.isClosed()){
                statement.close();
            }
        }
    }

    public static ResultSet getData(String sql) throws SQLException {

        //getConnectionDB();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement= connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

}
