package model;

import java.util.ArrayList;
import java.util.List;

public class Train {
	public String trainId="17236" ;
	public String trainName="Chennai Mail";
    public String start="20 Sep 2017 9.00 AM";
    public String end="20 Sep 2017 3.00 PM";
    public Schedule schedule= null;
    public String traintype="Express";    
	
    
    public Train(String trainId, String trainName, String start, String end, Schedule schedule, String traintype) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.start = start;
		this.end = end;
		this.schedule = schedule;
		this.traintype = traintype;
	}
    
    public List<Train> getTrainsList(){
    	List<Train> trains = new ArrayList<Train>();
    	trains.add(new Train("1", "Bangalore Express", "9.00 AM", "3.00 PM", null, "Express"));
    	trains.add(new Train("2", "Chennai Express", "10.00 AM", "20 Sep 2017 2.00 PM", null, "Shatabdi"));
    	trains.add(new Train("3", "Hyderabad Express", "1.00 AM", "7.00 PM", null, "Passenger"));
    	return trains;
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
	public  String getStart() {
		return start;
	}
	public  void setStart(String start) {
		this.start = start;
	}
	public  String getEnd() {
		return end;
	}
	public  void setEnd(String end) {
		this.end = end;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public  String getTraintype() {
		return this.traintype;
	}
	public  void setTraintype(String traintype) {
		this.traintype = traintype;
	}
}
