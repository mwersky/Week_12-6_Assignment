package entities;

public class Sales {

	private int saleId;
	private String dateOfSale; 
	private Cars car; 
	private int carId; 
	private Customers customer;
	private int customerId; 
//	private double profit;
	
	public Sales(int saleId, int customerId, int carId, String dateOfSale) {
		this.setSaleId(saleId); 
		this.setCustomerId(customerId);
		this.setCarId(carId);
		this.setDateOfSale(dateOfSale);
	}
	
	private void setCarId(int carId) {
		this.carId = car.getCarId(); 
	}
	
	public int getCarId() {
		return carId; 
	}
	
	public int getCustomerId() {
		return customerId; 
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customer.getCustomerId(); 
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public String getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(String dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

//	public double getProfit() {
//		return profit;
//	}
//
//	public void setProfit(int profit) {
//		this.profit = profit;
//	}
	
}
