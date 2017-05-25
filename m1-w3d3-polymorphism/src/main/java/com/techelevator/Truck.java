package com.techelevator;

public class Truck implements Vehicle {
	private int axles;
	
	public Truck(int axles) {
		this.axles = axles;
	}
	
	public String getVehicleName(){
		return "Truck";
	}
	
	public int getAxles() {
		return axles;
	}
	
	public void setAxles(int axles) {
		this.axles = axles;
	}

	@Override
	public double calculateToll(double distance) {
		if(axles >= 8) {
			return distance * 0.048;
		}
		else if (axles == 6) {
			return distance * 0.045;
		}
		else if (axles == 4) {
			return distance * 0.040;
		}
		return 0;
	}

}
