package application;

import java.util.Scanner;

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

	
//_______________________________________________________________________________________________________________//	
	
	//Methods that list the menu and sub menu's
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

//_______________________________________________________________________________________________________________//		
		
		}
		
		//Methods that will handle the logic of the main Menu
		
		//The Main Menu Should always loop back to this when done.
		public void start() {
			String selection = "";
			
			do {
				printMenu();
				selection = scanner.nextLine();
				
				if ( selection.equals( "1" ) ) {
					//Customers Menu
				} else if (selection.equals( "2" ) ) {
					//CarMenu
				} else if (selection.equals("3")) {
					//SalesMenu
				}
				
			if (selection != "-1") {
				System.out.println("Press enter to Continue...");
				scanner.nextLine();
			}
				
			} while (!selection.equals("-1"));	
		}	
		
		
		//the Customers subMenu
		public void SubMenuCars() {
			String subSelection = "";
			
			do {
				subMenu();
				subSelection = scanner.nextLine();
				
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
				
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
		}
		

		//the Cars subMenu
		public void SubMenuCustomer() {
			String subSelection = "";
			
			do {
				subMenu();
				subSelection = scanner.nextLine();
				
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
				
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
		}


		//the Sales Menu
		public void SalesMenu() {
			String subSelection = "";
			
			do {
				salesMenu();
				subSelection = scanner.nextLine();
				
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
			
			if (subSelection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!subSelection.equals("-1"));
			
		}


				
		//_______________________________________________________________________________________________________________//
		
		//Helper methods for the rest
		
		//Sales Helper Methods
		private void viewRecentSales() {
			
		}
		private void viewSpecificSale() {		
			
		}
		private void createSale() {		
			
		}
		private void deleteSale() {		
			
		}
		
		//Customer helper methods
		private void createCustomer() {
			
		}
		private void readCustomer() {
			
		}
		private void updateCustomer() {
			
		}
		private void deleteCustomer() {
			
		}
		
		//Cars Helper Methods
private void createCar() {
			
		}
		private void readCar() {
			
		}
		private void updateCar() {
			
		}
		private void deleteCar() {
			
		}
}

