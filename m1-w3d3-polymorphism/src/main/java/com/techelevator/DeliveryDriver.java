package com.techelevator;

public interface DeliveryDriver {
	String getServiceName();
	double calculateRate(double distance, int weight);
		
}
