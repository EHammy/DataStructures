package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contact;
import util.DBConnectionUtil;

public class ContactDAO {
    private Connection connection;

    public ContactDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DBConnectionUtil.getConnection();
        } catch (SQLException ex) {
            System.err.println("Error getting database connection: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error loading MySQL JDBC driver: " + ex.getMessage());
        }
    }

    public boolean addContact(Contact contact) {
        boolean result = false;

        try {
            if (this.connection != null) {
                String sql = "INSERT INTO contact (name, email, message) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setString(1, contact.getName());
                preparedStatement.setString(2, contact.getEmail());
                preparedStatement.setString(3, contact.getMessage());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    result = true;
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error adding contact to database: " + ex.getMessage());
        }

        return result;
    }
}
