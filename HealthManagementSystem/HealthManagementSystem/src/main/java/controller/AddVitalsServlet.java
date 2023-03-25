package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnectionUtil;
import model.Vitals;

@WebServlet("/AddVitalsServlet")
public class AddVitalsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get input parameters
        String bp = request.getParameter("bp");
        String hr = request.getParameter("hr");
        String temp = request.getParameter("temp");
        String weight = request.getParameter("weight");
        String dateString = request.getParameter("date");

        // Parse date
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        // Create Vitals object
        Vitals vitals = new Vitals(bp, hr, temp, weight, date);

        // Save to database
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBConnection.getConnection();

            String sql = "INSERT INTO vitals (bp, hr, temp, weight, date) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, vitals.getBp());
            stmt.setString(2, vitals.getHr());
            stmt.setString(3, vitals.getTemp());
            stmt.setString(4, vitals.getWeight());
            stmt.setDate(5, new java.sql.Date(vitals.getDate().getTime()));
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                response.sendRedirect("success.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
