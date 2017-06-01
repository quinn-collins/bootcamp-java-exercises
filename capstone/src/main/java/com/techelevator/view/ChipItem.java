package com.techelevator.view;

public class ChipItem extends VendingMachineItem {

	public ChipItem(String name, double price, int itemsRemaining) {
		super(name, price, itemsRemaining);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Crunch Crunch, Yum!");
	}
	
}
