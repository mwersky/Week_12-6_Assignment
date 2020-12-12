package entities;

public class Sales {

	private int saleId;
	private int dateOfSale; 
	private Cars carId;
	private Customers customerId; 
	
	public Sales(int saleId, Customers customerId, Cars carId, int dateOfSale) {
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

	public int getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(int dateOfSale) {
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
	
}
