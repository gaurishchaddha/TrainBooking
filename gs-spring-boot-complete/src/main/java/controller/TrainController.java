package controller;

import org.springframework.web.bind.annotation.RestController;

import model.Station;
import model.Train;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TrainController {
	
	public static ArrayList<Train> trains = new ArrayList<Train>();
	public static ArrayList<Station> stations = new ArrayList<Station>();	
	
    @RequestMapping("/trains")
    public ArrayList<Train> getTrains() {      	
    	return getTrainsList();
    }
    
    @RequestMapping("/trains/{trainID}")
    public Train getTrain(@PathVariable	 String trainID) {
    	System.out.println("Train ID" + trainID);
    	ArrayList<Train> trains= getTrainsList();
		for(Train train : trains){
    		if(train.trainId.contains(trainID)){
    			return train;
    		}
    	}    
    	return null;
    }
    
    @RequestMapping("/stations")
    public ArrayList<Station> getStations() {
    	stations.add(new Station(1, "Bangalore"));
    	stations.add(new Station(2, "Chennai"));
    	stations.add(new Station(3, "Hyderabad"));
    	return stations;
    }
    
}
