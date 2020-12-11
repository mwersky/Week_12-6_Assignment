package entities;

public class Cars {

	private int carId;
	private String model; 
	private String make; 
	private int modelYear;
	private double price; 
	
	public Cars(int carId, String model, String make, int modelYear, double price) {
		this.setCarId(carId); 
		this.setModel(model); 
		this.setMake(make); 
		this.setModelYear(modelYear); 
		this.setPrice(price); 
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
