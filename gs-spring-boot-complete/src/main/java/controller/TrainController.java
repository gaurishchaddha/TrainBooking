package controller;

import org.springframework.web.bind.annotation.RestController;

import model.Station;
import model.Train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TrainController {

    @GetMapping("/trains")
    public ArrayList<Train> getTrains() throws SQLException {
        return Train.selectAll();
    }

    @GetMapping("/trains/{trainId}")
    public Train getTrain(@PathVariable String trainId) throws SQLException {
        return Train.getTrainByTrainId(trainId);
    }

    @GetMapping("/stations")
    public ArrayList<Station> getStations() {
        return Station.selectAll();
    }
    
    @GetMapping("/stations/{stationId}")
    public Station getStation(@PathVariable int stationId) throws SQLException{
        return Station.getStationByStationId(stationId);
    }

}
