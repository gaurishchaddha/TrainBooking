package controller;

import org.springframework.web.bind.annotation.RestController;

import model.Station;
import model.Train;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.TrainServiceImpl;

@RestController
public class TrainController {

    @GetMapping("/trains")
    public ArrayList<Train> getTrains() throws SQLException {
        return TrainServiceImpl.getTrains();
    }

    @GetMapping("/trains/{trainId}")
    public Train getTrain(@PathVariable String trainId) throws SQLException {
        return TrainServiceImpl.getTrainByTrainId(trainId);
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
