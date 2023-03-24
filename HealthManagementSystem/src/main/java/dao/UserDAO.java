package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnectionUtil;
import model.User;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DBConnectionUtil.getConnection();
        } catch (SQLException ex) {
            System.err.println("Error getting database connection: " + ex.getMessage());
        }
    }

    public boolean addUser(User user) {
        boolean result = false;

        try {
            if (this.connection != null) {
                String sql = "INSERT INTO users (id, username, password, email) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getUsername());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.setString(4, user.getEmail());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    result = true;
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error adding user to database: " + ex.getMessage());
        }

        return result;
    }
}
