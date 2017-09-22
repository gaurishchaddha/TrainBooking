/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Train;
import repository.DBConnect;

/**
 *
 * @author vpatil
 */
public class TrainServiceImpl {
       public static ArrayList<Train> getTrains() throws SQLException {
        ArrayList<Train> trains = new ArrayList<Train>();
        try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT [trainId] ,[trainName] ,[startTime],[endTime],[scheduleId],[traintype] FROM Train");) {
            // loop through the result set
            while (rs.next()) {
                trains.add(new Train(rs.getString("trainId"), rs.getString("trainName"), rs.getString("startTime"), rs.getString("endTime"), rs.getString("scheduleId"), rs.getString("traintype")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return trains;
    }

    public static Train getTrainByTrainId(String trainId) throws SQLException {
        Train train = null;
        try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT [trainId] ,[trainName] ,[startTime],[endTime],[scheduleId],[traintype] FROM Train WHERE trainId = '" + trainId + "'");) {
            while (rs.next()) {
                train = new Train(rs.getString("trainId"), rs.getString("trainName"), rs.getString("startTime"), rs.getString("endTime"), rs.getString("scheduleId"), rs.getString("traintype"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return train;
    }
    
}
