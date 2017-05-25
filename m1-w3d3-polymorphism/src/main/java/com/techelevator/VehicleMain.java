package com.techelevator;

public class VehicleMain {
	
	public static void main(String[] args) {
	
		Vehicle[] vehicles = new Vehicle[] { new Car(true), new Car(false), new Truck(4), new Truck(8), new Tank() };
		String format1 = "%-11s%-17s%10s";
		String format2 = "%-11s%-9d$%20.02f";
		System.out.format(format1, "Vehicle", "Distance Traveled", "Toll $");
		System.out.println();
		System.out.println("---------------------------------------");
		for(Vehicle vehicle : vehicles) {
			int distance = (int)(Math.random()*230)+10;
			System.out.format(format2, vehicle.getVehicleName(), distance, vehicle.calculateToll(distance));
			System.out.println();
		}
	}
}
