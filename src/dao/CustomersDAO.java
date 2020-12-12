package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Customers;

public class CustomersDAO {
	
	private Connection connection; 
	private final String CREATE_CUSTOMER = "INSERT INTO customers (first_name, last_name) VALUES (?, ?)";
	private final String READ_CUSTOMER = "SELECT * FROM customers WHERE id = ?"; 
	private final String UPDATE_CUSTOMER = "UPDATE customers SET first_name = ?, last_name = ?";
	private final String DELETE_CUSTOMER = "DELETE FROM customers WHERE id = ?";

	public CustomersDAO() {
		connection = DBConnection.getConnection();
	}
	
	public void createCustomer(String first_name, String last_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER);
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.executeUpdate();
	}	
	
	public Customers readCustomer(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(READ_CUSTOMER);
		ps.setInt(1, id); 
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateCustomers(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	public void updateCustomer(String first_name, String last_name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
		ps.setString(1, first_name);
		ps.setString(2, last_name);
		ps.executeUpdate();
	}	
	
	public void deleteCustomer(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
		ps.setInt(1, id);
		ps.executeUpdate();
	}		

	private Customers populateCustomers(int id, String first_name, String last_name) {
		return new Customers(id, first_name, last_name);  
	}	
	
}
