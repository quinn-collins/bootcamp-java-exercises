package com.techelevator;

public class Car implements Vehicle {
	
	private boolean hasTrailer;
	
	public Car(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	
	public String getVehicleName(){
		return "Car";
	}
	
	public boolean getHasTrailer() {
		return hasTrailer;
	}
	
	public void setHasTrailer(boolean hasTrailer) {
		this.hasTrailer = hasTrailer;
	}
	
	@Override
	public double calculateToll(double distance) {
		if(hasTrailer) {
			return (distance * 0.020) + 1;
		}
		else {
			return distance * 0.020;
		}
	}

}
