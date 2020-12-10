package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private final static String URL = "jdbc:mysql://localhost:3306/GameCharacter";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "1457@cfg7c"; //THIS WILL NOT WORK WITHOUT ENTERING YOUR PASSWORD!
	
	private static DBConnection instance = new DBConnection(); //eager construction . When you immediately take something
															   // and put it right into the construction.
	private static Connection connection;
	
	private DBConnection() {}
	
	public static DBConnection getInstance() {
		return instance;
	}
	
	//instance method (not class method)
	public synchronized Connection getConnection() { //in case multiple threads attempt to execute
		if ( connection == null ) { //the instance checks for nullity of the connection, which may fail from time to time
			try {
				connection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
				System.out.println("Connection Successful!");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
				return connection;
			}

	/*
	 * our substitute professor recommended this format for our DBConnection and gave a huge list of reasons why this was
	 * the way to go so I moved mine over. Ultimately
	 */
	
}
