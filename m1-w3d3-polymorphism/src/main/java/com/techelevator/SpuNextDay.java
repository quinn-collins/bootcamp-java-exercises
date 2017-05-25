package com.techelevator;

public class SpuNextDay implements DeliveryDriver {

	@Override
	public String getServiceName() {
		return "SPU (next-day)";
	}

	@Override
	public double calculateRate(double distance, int weight) {
		return (weight * 0.075) * distance;
	}

}
