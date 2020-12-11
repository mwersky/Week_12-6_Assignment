package application;

import java.sql.SQLException;
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
		private void carSales() {
			System.out.println("------------");
			System.out.println("What would you like to do?");
			for ( int i = 0; i < menuOpts.length; i++) {
				System.out.println((i + 1) + ") " + carSales[i]);
			
				}	

		
		
		}
		
		//Methods that will handle the logic of the main Menu
		
		//The Main Menu Should always loop back to this when done.
		public void startMenu() {
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
		public void subMenuCustomer() {
			String selection = "";
			
			do {
				subMenu();
				selection = scanner.nextLine();
				
				if (selection.equals("1")) {
					//createCustomer();
				} else if (selection.equals("2")) {
					//readCustomer();
				} else if (selection.equals("3")) {
					//update();					
				} else if (selection.equals("4")) {
					//delete();
				}
				
			if (selection != "-1") {
				System.out.println("Press enter to Continue");
				scanner.nextLine();
			}
			} while (!selection.equals("-1"));
		}
		
		//the Cars subMenu
		
		
}

