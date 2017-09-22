package model;

import repository.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
