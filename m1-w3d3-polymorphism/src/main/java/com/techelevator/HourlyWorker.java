package com.techelevator;

public class HourlyWorker implements Worker {
	String firstName = "";
	String lastName = "";
	private double hourlyRate;
	
	public HourlyWorker(String firstName, String lastName, double hourlyRate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
	}

	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public double calculateWeeklyPay(double hoursWorked) {
		double pay = hourlyRate * hoursWorked;
		double overtime = 0;
		if(hoursWorked > 40){
			overtime = hoursWorked - 40;
		}
		return pay + (hourlyRate * overtime * .5);
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}

}
