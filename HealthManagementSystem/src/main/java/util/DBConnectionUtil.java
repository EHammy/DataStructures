package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/fitness_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "J4GsltW32!";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}

