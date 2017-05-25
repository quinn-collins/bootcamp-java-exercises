package com.techelevator;

public class Main {

	public static void main(String[] args) {
		Worker[] workers = new Worker[] { new SalaryWorker("Steve", "Smith", 100000), new HourlyWorker("Jane", "Johnson", 15), new VolunteerWorker("Sarah", "Stephens") };
		
		for(Worker worker : workers) {
			String firstName = worker.getFirstName();
			String lastName = worker.getLastName();
			double hoursWorked = (Math.random() * 45) + 25;
			double weeklyPay = worker.calculateWeeklyPay(hoursWorked);
			
			System.out.println(String.format("%s, %s %f $%.02f", lastName, firstName, hoursWorked, weeklyPay));
		}
	}

}
