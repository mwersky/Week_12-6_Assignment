package entities;

public class Sales {

	private int saleId;
	private String dateOfSale; 
	private Cars carId;
	private Customers customerId;
	private int profit;
	
	public Sales(int saleId, Customers customerId, Cars carId, String dateOfSale, Int profit) {
		this.setSaleId(saleId); 
		this.setCustomerId(customerId);
		this.setCarId(carId);
		this.setDateOfSale(dateOfSale);
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

	public Customers getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customers customerId) {
		this.customerId = customerId;
	}

	public Cars getCarId() {
		return carId;
	}

	public void setCarId(Cars carId) {
		this.carId = carId;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}
	
}
