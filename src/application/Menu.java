package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.CarsDAO;
import dao.SalesDAO;
import dao.CustomersDAO;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private String[] menuOpts = { //I like how you can just keep adding more options as you build the menu. 
			"Create an Entry", //Being able to add options as I work on them in groups is a little more  
			"Read an Entry",     //how I handle tasks so It's a little easier than just full top down approach.
			"Update an Entry",
			"Delete an Entry",
			"-1 to end operations" 
			};

	
	private CarsDAO carsDao = new CarsDAO();
	private CustomersDAO customersDao = new CustomersDAO();
	private SalesDAO customersCarsDao = new SalesDAO();

	//Method that lists the menu
	private void printMenu() {
		System.out.println("------------");
		System.out.println("Welcome Warrior. What would you like to do today?");
		for ( int i = 0; i < menuOpts.length; i++) {
			System.out.println((i + 1) + ") " + menuOpts[i]);
		}
	}

	//Primary Start Method and Menu Logic
		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				
				//process choice
				try {
					if ( selection.equals( "1" ) ) {
					//	createEntry();
					} else if (selection.equals( "2" ) ) {
					//	readEntry();
					} else if (selection.equals("3")) {
					//	updateEntry();
					} else if (selection.equals("4")) {
					//	deleteEntry();
					}
				} catch ( SQLException e ) {
					e.printStackTrace();					
				}				
			if (selection != "-1") {
				System.out.println("Press enter to Continue...");
				scanner.nextLine();
		}
				
			} while (!selection.equals("-1"));	
		}	
}

