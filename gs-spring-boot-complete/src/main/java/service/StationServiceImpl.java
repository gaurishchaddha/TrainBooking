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
import model.Station;
import repository.DBConnect;

/**
 *
 * @author vpatil
 */
public class StationServiceImpl {
       public static ArrayList<Station> selectAll() {
        ArrayList<Station> stations = new ArrayList<Station>();

        try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT [stationId] ,[stationName] FROM Station");) {
            // loop through the result set
            while (rs.next()) {
                stations.add(new Station(rs.getInt("stationId"), rs.getString("stationName")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stations;
    }

    public static Station getStationByStationId(int stationId) {
        Station station = null;        
        
        try (Connection conn = DBConnect.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT [stationId] ,[stationName] FROM Station WHERE stationId = " + stationId);) {
            while (rs.next()) {
                station = new Station(rs.getInt("stationId"), rs.getString("stationName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return station;
    }
    
}
