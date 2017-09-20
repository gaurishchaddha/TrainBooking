package hello;

import org.springframework.web.bind.annotation.RestController;

import model.Station;
import model.Train;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TrainController {
    
    @RequestMapping("/trains")
    public ArrayList<Train> getTrains() {
        
    	ArrayList<Train> trains = new ArrayList<Train>();
    	trains.add(new Train("1", "Bangalore Express", "9.00 AM", "3.00 PM", null, "Express"));
    	trains.add(new Train("2", "Chennai Express", "10.00 AM", "20 Sep 2017 2.00 PM", null, "Shatabdi"));
    	trains.add(new Train("3", "Hyderabad Express", "1.00 AM", "7.00 PM", null, "Passenger"));
    	return trains;
    }
    
    @RequestMapping("/stations")
    public ArrayList<Station> getStations() {
        
    	ArrayList<Station> stations = new ArrayList<Station>();
    	stations.add(new Station(1, "Bangalore"));
    	stations.add(new Station(2, "Chennai"));
    	stations.add(new Station(3, "Hyderabad"));
    	return stations;
    }
    
}
