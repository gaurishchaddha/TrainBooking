package model;

public class Train {
	public static String trainId="1234" ;
    public static String getTrainId() {
		return trainId;
	}
	public static void setTrainId(String trainId) {
		Train.trainId = trainId;
	}
	public static String getTrainName() {
		return trainName;
	}
	public static void setTrainName(String trainName) {
		Train.trainName = trainName;
	}
	public static String getStart() {
		return start;
	}
	public static void setStart(String start) {
		Train.start = start;
	}
	public static String getEnd() {
		return end;
	}
	public static void setEnd(String end) {
		Train.end = end;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public static String getTraintype() {
		return traintype;
	}
	public static void setTraintype(String traintype) {
		Train.traintype = traintype;
	}
	public static int getNumseates() {
		return numseates;
	}
	public static void setNumseates(int numseates) {
		Train.numseates = numseates;
	}
	public static String trainName="123456";
    public static String start="123456";
    public static String end="123456";
    public Schedule schedule= null;
    public static String traintype="";
    public static int numseates= 100;
    
}
