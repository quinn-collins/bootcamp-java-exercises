package com.techelevator;

public class SalaryWorker implements Worker {
	String firstName = "";
	String lastName = "";
	double annualSalary;
	@Override
	public double calculateWeeklyPay(int hoursWorked) {
		return 1.2;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}

}
