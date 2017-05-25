package com.techelevator;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int weight;
		double distance;
		
		DeliveryDriver[] drivers = new DeliveryDriver[] { new FirstClassPostal(), new SecondClassPostal(), new ThirdClassPostal(), new Fexed(), new SpuFourDay(), new SpuTwoDay(), new SpuNextDay()  };

		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the weight of the package:");
		weight = input.nextInt();
		input.nextLine();
		
		System.out.println("(P)ounds or (O)unces?");
		String units = input.nextLine();
		if(units.equalsIgnoreCase("P")) {
			weight *= 16;
		}
		
		System.out.println("What distance will it be traveling?");
		distance = input.nextDouble();
		input.nextLine();
		
		String format1 = "%-30s%-6s";
		System.out.format(format1, "Delivery Method", "Cost");
		System.out.println();
		System.out.println("----------------------------------");
		String format2 = "%-30s$%-6.02f";
		for(DeliveryDriver driver : drivers) {
			System.out.format(format2, driver.getServiceName(), driver.calculateRate(distance, weight));
			System.out.println();
		}
	}
}
