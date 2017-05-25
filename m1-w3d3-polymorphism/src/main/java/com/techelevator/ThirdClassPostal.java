package com.techelevator;

public class ThirdClassPostal implements DeliveryDriver {
	@Override
	public String getServiceName() {
		return "Postal Service (3rd Class)";
	}
	
	@Override
	public double calculateRate(double distance, int weight) {
		double rate;
		if (weight >= 144) {
			rate = 0.0170 * distance;
			return rate;
		}
		else if (weight >= 64) {
			rate = 0.0160 * distance;
			return rate;
		}
		else if (weight >= 16) {
			rate = 0.0150 * distance;
			return rate;
		}
		else if (weight >= 9) {
			rate = 0.0024 * distance;
			return rate;
		}
		else if(weight >= 3) {
			rate = 0.0022 * distance;
			return rate;
		}
		else {
			rate = 0.0020 * distance;
			return rate;
		}
	}
}
