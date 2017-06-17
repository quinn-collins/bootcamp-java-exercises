package com.techelevator;

public class SalaryWorker implements Worker {
	private String firstName = "";
	private String lastName = "";
	double annualSalary;
	
	public SalaryWorker(String firstName, String lastName, double annualSalary){
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = annualSalary;
	}

	@Override
	public double calculateWeeklyPay(double hoursWorked) {
		return annualSalary / 52;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public String getLastName() {
		return lastName;
	}
	
	public double getAnnualSalary() {
		return annualSalary;
	}

}
