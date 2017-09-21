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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TrainController {

	public static ArrayList<Train> trains = new ArrayList<Train>();
	public static ArrayList<Station> stations = new ArrayList<Station>();

	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:C://Users//vsp//TrainBooking//DBScripts//TrainBooking.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public JSONArray selectAll() throws JSONException {
		String out = null;
		String sql = "SELECT [trainId] ,[trainName] ,[startTime],[endTime],[scheduleId],[traintype] FROM Train";
		JSONArray jsonArray = new JSONArray();

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				// System.out.println(rs.getInt("id") + "\t"
				// + rs.getString("name") + "\t"
				// + rs.getDouble("capacity"));
				System.out.println(rs.getString("trainId") + " trainId\t" + rs.getString("trainName") + " trainName\t"
						+ rs.getString("startTime") + " startTime\t" + rs.getString("endTime") + " endTime\t"
						+ rs.getString("scheduleId") + " scheduleId\t" + rs.getString("traintype") + " traintype\t");
				
				int total_rows = rs.getMetaData().getColumnCount();
				for (int i = 0; i < total_rows; i++) {
					JSONObject obj = new JSONObject();
					obj.put(rs.getMetaData().getColumnLabel(i + 1).toLowerCase(), rs.getObject(i + 1));
					jsonArray.put(obj);
				}
			}
			

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return jsonArray;
	}

	@RequestMapping("/trains")
	public String getTrains() throws JSONException {
		return selectAll().toString();
	}

	@RequestMapping("/trains/{trainID}")
	public Train getTrain(@PathVariable String trainID) {
		System.out.println("Train ID" + trainID);
		// ArrayList<Train> trains= getTrainsList();
		for (Train train : trains) {
			if (train.trainId.contains(trainID)) {
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
