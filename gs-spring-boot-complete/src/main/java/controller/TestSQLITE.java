/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vpatil
 */
public class TestSQLITE {

    /**
     * Connect to a sample database
     */

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users//vsp//TrainBooking//DBScripts//TrainBooking.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestSQLITE test = new TestSQLITE();
        test.selectAll();
    }

    public void selectAll() {
        String sql = "SELECT [trainId] ,[trainName] ,[startTime],[endTime],[scheduleId],[traintype] FROM Train";

        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
//                System.out.println(rs.getInt("id") + "\t"
//                        + rs.getString("name") + "\t"
//                        + rs.getDouble("capacity"));
                System.out.println(rs.getString("trainId") + " trainId\t"
                        + rs.getString("trainName") + " trainName\t"
                        + rs.getString("startTime") + " startTime\t"
                        + rs.getString("endTime") + " endTime\t"
                        + rs.getString("scheduleId") + " scheduleId\t"
                        + rs.getString("traintype") + " traintype\t"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
