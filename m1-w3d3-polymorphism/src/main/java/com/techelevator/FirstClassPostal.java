package com.techelevator;

public class FirstClassPostal implements DeliveryDriver {
	@Override
	public String getServiceName() {
		return "Postal Service (1st Class)";
	}
	
	@Override
	public double calculateRate(double distance, int weight) {
		double rate;
		if (weight >= 144) {
			rate = 0.5 * distance;
			return rate;
		}
		else if (weight >= 64) {
			rate = 0.45 * distance;
			return rate;
		}
		else if (weight >= 16) {
			rate = 0.195 * distance;
			return rate;
		}
		else if (weight >= 9) {
			rate = 0.047 * distance;
			return rate;
		}
		else if(weight >= 3) {
			rate = 0.04 * distance;
			return rate;
		}
		else {
			rate = 0.035 * distance;
			return rate;
		}
	}
}
