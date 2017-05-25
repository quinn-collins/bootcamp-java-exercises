package com.techelevator;

public class SpuTwoDay implements DeliveryDriver {

	@Override
	public String getServiceName() {
		return "SPU (2-day business)";
	}

	@Override
	public double calculateRate(double distance, int weight) {
		return (weight * 0.050) * distance;
	}

}
