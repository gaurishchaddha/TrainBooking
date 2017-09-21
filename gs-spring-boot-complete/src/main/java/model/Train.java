package model;

import repository.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class Train {

    public String trainId;
    public String trainName;
    public String startTime;
    public String endTime;
    public String scheduleId;
    public String traintype;

    public Train(String trainId, String trainName, String start, String end, String schedule, String traintype) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.startTime = start;
        this.endTime = end;
        this.scheduleId = schedule;
        this.traintype = traintype;
    }

    public static ArrayList<Train> selectAll() throws SQLException {
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

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStart(String starttime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEnd(String endTime) {
        this.endTime = endTime;
    }

    public String getSchedule() {
        return scheduleId;
    }

    public void setSchedule(String schedule) {
        this.scheduleId = schedule;
    }

    public String getTraintype() {
        return this.traintype;
    }

    public void setTraintype(String traintype) {
        this.traintype = traintype;
    }
}
