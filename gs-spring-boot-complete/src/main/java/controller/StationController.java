/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Station;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.StationServiceImpl;

/**
 *
 * @author vpatil
 */
@RestController
public class StationController {

    @GetMapping("/stations")
    public ArrayList<Station> getStations() {
        return StationServiceImpl.selectAll();
    }

    @GetMapping("/stations/{stationId}")
    public Station getStation(@PathVariable int stationId) throws SQLException {
        return StationServiceImpl.getStationByStationId(stationId);
    }

}
