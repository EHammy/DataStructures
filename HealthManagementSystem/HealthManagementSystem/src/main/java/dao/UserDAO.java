package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DBConnectionUtil;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DBConnectionUtil.getConnection();
        } catch (SQLException ex) {
            System.err.println("Error getting database connection: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error loading MySQL JDBC driver: " + ex.getMessage());
        }
    }

    public boolean addUser(User user) {
        boolean result = false;

        try {
            if (this.connection != null) {
                String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());

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

    public User getUserByUsername(String username) {
        User user = null;

        try {
            if (this.connection != null) {
                String sql = "SELECT * FROM users WHERE username = ?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setString(1, username);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");

                    user = new User(id, username, password, email);
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error getting user from database: " + ex.getMessage());
        }

        return user;
    }
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;

        try {
            if (this.connection != null) {
                String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setEmail(resultSet.getString("email"));
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error retrieving user from database: " + ex.getMessage());
        }

        return user;
    }
}
