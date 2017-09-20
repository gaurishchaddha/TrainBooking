package model;

public class Schedule {

	private static String trainNumber;
	private static int sequence;
	private static String stationCode;
	private static String arrivalTime;
	private static String departureTime;
	private static int distancefromStart;
	private static int seatsAvailable;
	
	public static String getTrainNumber() {
		return trainNumber;
	}
	public static void setTrainNumber(String trainNumber) {
		Schedule.trainNumber = trainNumber;
	}
	public static int getSequence() {
		return sequence;
	}
	public static void setSequence(int sequence) {
		Schedule.sequence = sequence;
	}
	public static String getStationCode() {
		return stationCode;
	}
	public static void setStationCode(String stationCode) {
		Schedule.stationCode = stationCode;
	}
	public static String getArrivalTime() {
		return arrivalTime;
	}
	public static void setArrivalTime(String arrivalTime) {
		Schedule.arrivalTime = arrivalTime;
	}
	public static String getDepartureTime() {
		return departureTime;
	}
	public static void setDepartureTime(String departureTime) {
		Schedule.departureTime = departureTime;
	}
	public static int getDistancefromStart() {
		return distancefromStart;
	}
	public static void setDistancefromStart(int distancefromStart) {
		Schedule.distancefromStart = distancefromStart;
	}
	public static int getSeatsAvailable() {
		return seatsAvailable;
	}
	public static void setSeatsAvailable(int seatsAvailable) {
		Schedule.seatsAvailable = seatsAvailable;
	}
	
	
	
}
