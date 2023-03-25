package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost/fitness_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "J4GsltW32!";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Create a connection to the database
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        return conn;
    }
}
