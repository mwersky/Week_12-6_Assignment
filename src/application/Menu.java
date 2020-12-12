package application;

import java.sql.SQLException;
import java.util.Scanner;

import dao.CustomersDAO;
import dao.CarsDAO;
import dao.SalesDAO;


public class Menu {
	
	//Scanner initiation
	private Scanner scanner = new Scanner(System.in);
		
	//Menu Visuals
	private String[] menuOpts = { 
			"Work in Customers", 
			"Work in Cars",
			"Maintain Sales" 
			};
	
	private String[] subMenu = {
			"Create new Entry",
			"Read an Entry",
			"Update an Entry",
			"Delete an Entry",
			"Go Back"
	};
	
	private String[] carSales = {
		"View All Past Sales",
		"View a specific Sale",
		"Make a New Sale",
		"Delete a Sale",
		"Go Back"
	};

	private CustomersDAO customersDAO = new CustomersDAO();
	private CarsDAO carsDAO = new CarsDAO();
	private SalesDAO salesDao = new SalesDAO();
	
//________________________________________Methods that list the menu and sub menu's____________________________________//	
	
								
		private void printMenu() {
			System.out.println("------------");
			System.out.println("Welcome to the dealership. What would you like to do today?");
			for ( int i = 0; i < menuOpts.length; i++) {
				System.out.println((i + 1) + ") " + menuOpts[i]);
			
				}	
			}
		
		private void subMenu() {
			System.out.println("------------");
			System.out.println("What would you like to do?");
			for ( int i = 0; i < subMenu.length; i++) {
				System.out.println((i + 1) + ") " + subMenu[i]);
			
				}	
			}
		private void salesMenu() {
			System.out.println("------------");
			System.out.println("What would you like to do?");
			for ( int i = 0; i < carSales.length; i++) {
				System.out.println((i + 1) + ") " + carSales[i]);
			
				}				
		}
		
		//__________________________Methods that will handle the logic of the main Menu_________________________________//
		
		//The Main Menu Should always loop back to this when done.
		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				
				if ( selection.equals( "1" ) ) {
					SubMenuCustomer();
				} else if (selection.equals( "2" ) ) {
					SubMenuCars();
				} else if (selection.equals("3")) {
					SalesMenu();
				}
				
			if (selection != "-1") {
				System.out.println("Press enter to Continue...");
				scanner.nextLine();
			}
				
			} while (!selection.equals("-1"));	
		}	
		
		
		//____________________________________the Customers subMenu_________________________________________________//
		public void SubMenuCars() {
			String subSelection = "";
			
			do {
				subMenu();
				subSelection = scanner.nextLine();
				
				try {
				if (subSelection.equals("1")) {
					createCar();
				} else if (subSelection.equals("2")) {
					readCar();
				} else if (subSelection.equals("3")) {
					updateCar();					
				} else if (subSelection.equals("4")) {
					deleteCar();
				} else if (subSelection.equals("5")) {
					start(); //this method takes us back to the main menu.
				}			
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
				
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
		}
		

		//_________________________________________the Cars subMenu_________________________________________________//
		public void SubMenuCustomer() {
			String subSelection = "";
			
			do {
				subMenu();
				subSelection = scanner.nextLine();
				
				try {
				if (subSelection.equals("1")) {
					createCustomer();
				} else if (subSelection.equals("2")) {
					readCustomer();
				} else if (subSelection.equals("3")) {
					updateCustomer();					
				} else if (subSelection.equals("4")) {
					deleteCustomer();
				} else if (subSelection.equals("5")) {
					start(); //this method takes us back to the main menu.
				}
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
				
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
		}


		//___________________________________________the Sales Menu______________________________________________//
		public void SalesMenu() {
			String subSelection = "";
			
			do {
				salesMenu();
				subSelection = scanner.nextLine();
				
				try {
					
				if (subSelection.equals("1")) {
					viewRecentSales();
				} else if (subSelection.equals("2")) {
					viewSpecificSale();
				} else if (subSelection.equals("3")) {
					createSale();
				} else if (subSelection.equals("4")) {
					deleteSale();
				} else if (subSelection.equals ("5")) {
					start();
				}
				
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
			
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
			
		}

				
		

		
		//______________________________________HELPER METHODS FOR THE REST_______________________________________________//
		
		
		
		//_________________________________________SALES HELPER METHODS___________________________________________________//
		private void viewRecentSales() throws SQLException {
			
		}
		private void viewSpecificSale() throws SQLException {
		}
		private void createSale() throws SQLException {		
			
		}
		private void deleteSale() throws SQLException {		
			
		}
		
		//______________________________________CUSTOMER HELPER METHODS___________________________________________________//
		private void createCustomer() throws SQLException {
			System.out.println("First Name: ");
			String firstName = scanner.nextLine();
			System.out.println("Last Name: ");
			String lastName = scanner.nextLine();
			if (firstName.length() > 0 && lastName.length() > 0) {
				customersDAO.createCustomer ( firstName, lastName );
			}
		}
		private void readCustomer() throws SQLException {
			System.out.println("Customer id no: ");
			String custId = scanner.nextLine();
			if (custId.length() == 6) {				
				int custIdConvert = Integer.parseInt(custId);
				customersDAO.readCustomer( custId );
			}
		}
		private void updateCustomer() throws SQLException {
			System.out.println("Customer id no: ");
			String custId = scanner.nextLine();
			System.out.println("New first name: ");
			String firstName = scanner.nextLine();
			System.out.println("New last name: ");
			String lastName = scanner.nextLine();
			
			if (custId.length() == 6 && firstName.length() > 0 && lastName.length() > 0) {
				int custIdConvert = Integer.parseInt(custId);
				customersDAO.updateCustomer( custId, firstName, lastName);
			}
			
		}
		private void deleteCustomer() throws SQLException {
			System.out.println("Customer id no: ");
			String custId = scanner.nextLine();
			if (custId.length() == 6) {
				int custIdConvert = Integer.parseInt(custId);
				customersDAO.deleteCustomer( custIdConvert );
			}
		} 
		
	//___________________________________________Cars Helper Methods_________________________________________________//
		private void createCar() throws SQLException { //holy text block.
			System.out.println("Car Model: ");
			String model = scanner.nextLine();
			
			System.out.println("Make :");
			String make = scanner.nextLine();
			
			System.out.println("Model_Year");
			String modelYear = scanner.nextLine();
			
			System.out.println("Price (to the .xx: ");
			String price = scanner.nextLine();
			
				if (model.length() > 0 && make.length() > 0 && modelYear.length() > 0 && price.length() > 0) {
					int modelYearConvert = Integer.parseInt(modelYear); //big brain code
					double priceConvert = Double.parseDouble(price); //more big brain code
					carsDAO.logNewCar(model, make, modelYearConvert, priceConvert);
				}
			
		}
		private void readCar() throws SQLException { //wow this was easy.
			System.out.println("Car identification number: ");
			String idNo = scanner.nextLine();
			
			if (idNo.length() > 0 ) {
				int idNoConvert = Integer.parseInt(idNo);
				carsDAO.getCarById(idNoConvert);
			}
			
		}
		private void updateCar() throws SQLException {
			System.out.println("Car identification number: ");
			String idNo = scanner.nextLine();
			
			System.out.println("Car Model: ");
			String model = scanner.nextLine();
			
			System.out.println("Make :");
			String make = scanner.nextLine();
			
			System.out.println("Model_Year");
			String modelYear = scanner.nextLine();
			
			System.out.println("Price (to the .xx: ");
			String price = scanner.nextLine();
			
				if (model.length() > 0 && make.length() > 0 && modelYear.length() > 0 && price.length() > 0) {
					int idNoConvert = Integer.parseInt(idNo); //big brain code
					int modelYearConvert = Integer.parseInt(modelYear);
					double priceConvert = Double.parseDouble(price); //more big brain code
					carsDAO.updateCarById(idNoConvert, model, make, modelYearConvert, priceConvert);
				}
			
		}
		private void deleteCar() throws SQLException {
			System.out.println("Car id no: ");
			String carId = scanner.nextLine();
			if (carId.length() == 6) {
				int carIdConvert = Integer.parseInt(carId);
				carsDAO.deleteCarById( carIdConvert );
			}
		}
}

