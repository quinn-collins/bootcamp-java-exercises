package com.techelevator;

public interface Worker {
	String firstName = "";
	String lastName = "";
	String getFirstName();
	String getLastName();
	double calculateWeeklyPay(int hoursWorked);
}

