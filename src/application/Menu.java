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
			"View All Entries by ID no.",
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
			System.out.println("-1 exits the application.");
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
		//______________________________________SUPER SPICY PASSWORD METHOD_____________________________________________//

		
		
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
		
		
		//____________________________________the Cars subMenu_________________________________________________//
		public void SubMenuCars() {
			String subCars = "";
			
			do {
				subMenu();
				subCars = scanner.nextLine();
				
				try {
				if (subCars.equals("1")) {
					createCar();
				} else if (subCars.equals("2")) {
					readCar();
				} else if (subCars.equals("3")) {
					updateCar();					
				} else if (subCars.equals("4")) {
					deleteCar();
				} else if (subCars.equals("5")) {
					viewAllCarsById();
				} else if (subCars.equals("6")) {
					start(); //this method takes us back to the main menu.
				}			
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
				
			if (subCars != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subCars.equals("-1"));
		}
		

		//_________________________________________the Customers subMenu_________________________________________________//
		public void SubMenuCustomer() {
			String subCustomers = "";
			
			do {
				subMenu();
				subCustomers = scanner.nextLine();
				
				try {
				if (subCustomers.equals("1")) {
					createCustomer();
				} else if (subCustomers.equals("2")) {
					readCustomer();
				} else if (subCustomers.equals("3")) {
					updateCustomer();					
				} else if (subCustomers.equals("4")) {
					deleteCustomer();
				} else if (subCustomers.equals("5")) {	
					viewAllCustById();
				} else if (subCustomers.equals("6")) {
					start(); //this method takes us back to the main menu.
				}
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
				
			if (subCustomers != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subCustomers.equals("-1"));
		}


		//___________________________________________the Sales Menu______________________________________________//
		public void SalesMenu() {
			String subSales = "";
			
			do {
				salesMenu();
				subSales = scanner.nextLine();
				
				try {
					
				if (subSales.equals("1")) {
					viewRecentSales();
				} else if (subSales.equals("2")) {
					viewSpecificSale();
				} else if (subSales.equals("3")) {
					createSale();
				} else if (subSales.equals("4")) {
					deleteSale();
				} else if (subSales.equals ("5")) {
					start();
				}
				
				} catch ( SQLException e ) {
					e.printStackTrace();
					
				}
			
			if (subSales != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSales.equals("-1"));
			
		}

				
		

		
		//______________________________________HELPER METHODS FOR THE REST_______________________________________________//
		/*
		 * Notes:
		 * I didn't really think for a second about how you can take a different variable other than a String from a scanner and just immediately fill in variables.
		 * To this extent I ended up leaving a lot of my original code because I was really proud of my work around. The Sales menu has all the most up to date code and should 
		 * be a great example of how I could have written this in a cleaner way.
		 */
		
		
		//_________________________________________SALES HELPER METHODS___________________________________________________//
		private void viewRecentSales() throws SQLException {
			System.out.println("Processing. One Moment...");		
			salesDao.getSales();
		}
		private void viewSpecificSale() throws SQLException {
			System.out.println("Enter Sales Identification Number: ");
			int saleId = scanner.nextInt();
			
			if (saleId > 0) {
			salesDao.getSaleById( saleId );
			}
		}
		private void createSale() throws SQLException {		
			System.out.println("Customer ID No:");
			int custId = scanner.nextInt();
			
			System.out.println("Car ID No");			
			int carId = scanner.nextInt();
			
			System.out.println("Profit of Sale: ");
			double profit = scanner.nextDouble();
			
			if (custId > 0 && carId > 0 && profit > 0) {
			salesDao.logNewSale(custId, carId);
			}
		}
		private void deleteSale() throws SQLException {		
			System.out.println("Sale Identification number: ");
			int saleId = scanner.nextInt();
			
			if( saleId > 0 ) {
			salesDao.deleteSaleById( saleId );
			}
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
				customersDAO.readCustomer( custIdConvert );
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
				customersDAO.updateCustomer( custIdConvert, firstName, lastName);
			}
			
		}
		private void viewAllCustById() throws SQLException {
			System.out.println("Processing. One Moment...");
			customersDAO.viewAllCust();
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
		private void viewAllCarsById() throws SQLException {
			System.out.println("Processing. One Moment...");
			carsDAO.getCars();
		}
}

