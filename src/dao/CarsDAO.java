package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Cars;

public class CarsDAO {

	private Connection connection; 
	private final String LIST_OF_ALL_CARS = "Select * From Cars";
	private final String SQL_QUERY_NUMBER_TWO = "Another query"; 
	private final String LOG_NEW_CAR = "INSERT INTO cars(model, make, model_year, price) VALUES (?, ?, ?, ?)";
	private final String SQL_QUERY_NUMBER_FOUR = "another"; 
	
	public CarsDAO() {
		connection = DBConnection.getConnection();  //I'm not sure why this doesn't work. 
		
	}
	
	public List<Cars> getCars() throws SQLException {
		ResultSet rs = connection.prepareStatement(LIST_OF_ALL_CARS).executeQuery(); 
		List<Cars> cars = new ArrayList<Cars>();
		
		while(rs.next()) {
			cars.add(populateCars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
		}
		
		return cars; 
	}
	
	public void logNewCar(String model, String make, int modelYear, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(LOG_NEW_CAR);
		ps.setString(1, model);
		ps.setString(2, make);
		ps.setInt(3, modelYear);
		ps.setDouble(4, price);
		ps.executeUpdate();
		
	}
	
	private Cars populateCars(int carId, String model, String make, int modelYear, double price) {
		return new Cars(carId, model, make, modelYear, price);
	}
}
