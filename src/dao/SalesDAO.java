package dao;

import java.sql.Connection;

public class SalesDAO {

	private Connection connection;
	private final String VIEW_RECENT_SALES = "SELECT * FROM sales";
	private final String VIEW_SPECIFIC_SALE = "SELECT * FROM sales WHERE id = ?";
	private final String LOG_NEW_SALE = "INSERT INTO sales(customer_id, car_id) VALUES (?, ?)";
	private final String DELETE_A_SALE = "DELETE FROM sales WHERE id = ?";
	public SalesDAO() {
	connection = DBConnection.getConnection(); //just like in the cars dao, this .getconnection doesn't work :( 
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