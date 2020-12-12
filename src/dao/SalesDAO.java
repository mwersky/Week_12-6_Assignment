package dao;

import java.sql.Connection;

public class SalesDAO {

	private Connection connection;
	private final String SQL_STATEMENT_ONE = "Statments";
	private final String SQL_STATEMENT_TWO = "more statements";
	private final String SQL_QUERY_NUMBER_THREE = "another";
	private final String SQL_QUERY_NUMBER_FOUR = "another";
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