package entities;


public class Customers {

	
	private int customerId;
	private String firstName;
	private String lastName;

	
	public Customers(int customerId, String firstName, String lastName) {
		this.setCustomerId(customerId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	
	//Getters and setters.
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
