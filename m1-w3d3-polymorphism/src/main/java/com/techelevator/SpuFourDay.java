package com.techelevator;

public class SpuFourDay implements DeliveryDriver {

	@Override
	public String getServiceName() {
		return "SPU (4-day ground)";
	}

	@Override
	public double calculateRate(double distance, int weight) {
		return (weight * 0.0050) * distance;
	}

}
