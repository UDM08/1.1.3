package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/dbtest";
    private static final String username = "root";
    private static final String password = "root1";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection succesfull!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection error!");
        }
        return connection;
    }
}


