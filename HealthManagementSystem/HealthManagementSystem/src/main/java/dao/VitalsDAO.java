package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Vitals;
import util.DBConnectionUtil;

public class VitalsDAO {

    private Connection connection;

    public VitalsDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DBConnectionUtil.getConnection();
        } catch (SQLException ex) {
            System.err.println("Error getting database connection: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Error loading MySQL JDBC driver: " + ex.getMessage());
        }
    }

    public boolean addVitals(Vitals vitals) {
        boolean result = false;

        try {
            if (this.connection != null) {
                String sql = "INSERT INTO vitals (date, blood_pressure, heart_rate, temperature, weight) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setDate(1, vitals.getLocalDate());
                preparedStatement.setString(2, vitals.getBloodPressure());
                preparedStatement.setInt(3, vitals.getHeartRate());
                preparedStatement.setDouble(4, vitals.getTemperature());
                preparedStatement.setDouble(5, vitals.getWeight());

                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    result = true;
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error adding vitals to database: " + ex.getMessage());
        }

        return result;
    }

    public List<Vitals> getAllVitals() {
        List<Vitals> vitalsList = new ArrayList<>();

        try {
            if (this.connection != null) {
                String sql = "SELECT * FROM vitals";
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    java.sql.Date date = resultSet.getDate("date");
                    String bloodPressure = resultSet.getString("blood_pressure");
                    int heartRate = resultSet.getInt("heart_rate");
                    double temperature = resultSet.getDouble("temperature");
                    double weight = resultSet.getDouble("weight");

                    Vitals vitals = new Vitals(id, heartRate, temperature, weight);
                    vitalsList.add(vitals);
                }
            } else {
                System.err.println("Database connection is null");
            }
        } catch (SQLException ex) {
            System.err.println("Error getting all vitals from database: " + ex.getMessage());
        }

        return vitalsList;
    }
}
