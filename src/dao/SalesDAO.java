package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Cars;
import entities.Customers;
import entities.Sales;

public class SalesDAO {

	private Cars carsId; 
	private Customers customerId; 
	private Connection connection;
	private final String VIEW_RECENT_SALES = "SELECT * FROM sales LIMIT 15";
	private final String VIEW_SPECIFIC_SALE = "SELECT * FROM sales WHERE id = ?";
	private final String LOG_NEW_SALE = "INSERT INTO sales(customer_id, car_id, profit) VALUES (?, ?, ?)";
	private final String DELETE_A_SALE = "DELETE FROM sales WHERE id = ?";
	
	public SalesDAO() {
	connection = DBConnection.getConnection();
	}

	public List<Sales> getSales() throws SQLException {
		ResultSet rs = connection.prepareStatement(VIEW_RECENT_SALES).executeQuery(); 
		List<Sales> sales = new ArrayList<Sales>();
		
		while(rs.next()) {
			sales.add(populateSales(rs.getInt(1), customerId.setCustomerId(rs.getInt(2)), carsId.setIntToCarId(rs.getInt(3)), rs.getDate(4).toString(), rs.getInt(5)));
		}
//  Not sure how to add different entities to this querty :( 
		return sales; 
	}
	
	public Sales getSaleById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_SPECIFIC_SALE);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4).toString(), rs.getInt(5));
	}
	
	public void logNewSale(String model, String make, int modelYear, double price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(LOG_NEW_SALE);
		ps.setString(1, model);
		ps.setString(2, make);
		ps.setInt(3, modelYear);
		ps.setDouble(4, price);
		ps.executeUpdate();
		
	
	private Sales populateSales(int saleId, Customers cust_id, Cars car_id, String dateOfSale, int profit) {
		return new Sales(saleId, cust_id, car_id, dateOfSale, profit);
	}

//	private void viewRecentSales() {
//		
//	}
//	private void viewSpecificSale() {		
//		
//	}
//	private void createSale() {		
//		
//	}
//	private void deleteSale() {		
//		
//	}
}