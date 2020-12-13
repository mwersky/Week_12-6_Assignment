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
	private final String LIST_OF_ALL_CARS = "Select * From Cars"; //I'm going to add this method to the menu
	private final String LOG_NEW_CAR = "INSERT INTO cars(model, make, model_year, price) VALUES (?, ?, ?, ?)";
	private final String READ_DETAILS_OF_SPECIFIC_CAR = "SELECT * FROM cars WHERE id = ?";
	private final String UPDATE_A_CAR = "UPDATE cars SET mode = ?, make = ?, model_year = ?, price = ? WHERE id = ?";
	private final String DELETE_A_CAR = "DELETE FROM cars WHERE id = ?"; 
	
	public CarsDAO() {
		connection = DBConnection.getConnection();
		
	}
	
	// ------------  Method for viewing all cars in the database  --------------
	
	public List<Cars> getCars() throws SQLException {
		ResultSet rs = connection.prepareStatement(LIST_OF_ALL_CARS).executeQuery(); 
		List<Cars> cars = new ArrayList<Cars>();
		
		while(rs.next()) {
			cars.add(populateCars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
		}
		
		return cars;
	}
	
	// ------------ Method for adding a new car into the database --------------
	
	public void logNewCar(String model, String make, int modelYear, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(LOG_NEW_CAR);
		ps.setString(1, model);
		ps.setString(2, make);
		ps.setInt(3, modelYear);
		ps.setDouble(4, price);
		ps.executeUpdate();
		
	}
	
	// ------------ Method for viewing a specific car -------------
	
	public Cars getCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(READ_DETAILS_OF_SPECIFIC_CAR);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateCars(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
	}
	
	// ------------- Method for updating a specific car by id ------
	
	public void updateCarById(int id, String model, String make, int modelYear, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_A_CAR);
		ps.setString(1, model);
		ps.setString(2, make);
		ps.setInt(3, modelYear);
		ps.setDouble(4, price);
		ps.setInt(5, id);
		ps.executeUpdate(); 
		
	}
	
	// ------------ Method for deleting a specific car ------------
	
	public void deleteCarById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_A_CAR);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	//  ------------ Helper Method for adding car to a list ---------------
	
	private Cars populateCars(int carId, String model, String make, int modelYear, double price) {
		return new Cars(carId, model, make, modelYear, price);
	}
}
