package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Sales;

public class SalesDAO {

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
			sales.add(populateSales(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toString()));
		}
//  Not sure how to add different entities to this query :( 
		return sales; 
	}
	
	public Sales getSaleById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(VIEW_SPECIFIC_SALE);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateSales(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toString());
	}
	
	public void logNewSale(int cust_id, int car_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(LOG_NEW_SALE);
		ps.setInt(1, cust_id);
		ps.setInt(2, car_id);
//		ps.setDouble(3, profit);
		ps.executeUpdate();
	}
	
	public void deleteSaleById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_A_SALE);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Sales populateSales(int saleId, int cust_id, int car_id, String dateOfSale) {
		return new Sales(saleId, cust_id, car_id, dateOfSale);
	}
}