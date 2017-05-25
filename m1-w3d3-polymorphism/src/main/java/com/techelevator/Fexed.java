package com.techelevator;

public class Fexed implements DeliveryDriver {
	@Override
	public String getServiceName() {
		return "FexEd";
	}
	
	@Override
	public double calculateRate(double distance, int weight){
		double rate = 20;
		if(distance > 500) {
			rate = rate + 5.00;
		}
		if(weight > 48) {
			rate = rate + 3.00;
		}
		return rate;
	}

	
}
