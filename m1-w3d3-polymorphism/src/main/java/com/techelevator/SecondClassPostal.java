package com.techelevator;

public class SecondClassPostal implements DeliveryDriver {
	@Override
	public String getServiceName() {
		return "Postal Service (2nd Class)";
	}
	
	@Override
	public double calculateRate(double distance, int weight) {
		double rate;
		if (weight >= 144) {
			rate = 0.05 * distance;
			return rate;
		}
		else if (weight >= 64) {
			rate = 0.045 * distance;
			return rate;
		}
		else if (weight >= 16) {
			rate = 0.0195* distance;
			return rate;
		}
		else if (weight >= 9) {
			rate = 0.0047 * distance;
			return rate;
		}
		else if(weight >= 3) {
			rate =  0.004 * distance;
			return rate;
		}
		else {
			rate = 0.0035 * distance;
			return rate;
		}
	}
}
