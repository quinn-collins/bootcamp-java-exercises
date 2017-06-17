package com.techelevator.view;

public class ChipItem extends VendingMachineItem {

	public ChipItem(String name, double price, int itemsRemaining, int itemSold) {
		super(name, price, itemsRemaining, itemSold);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Crunch Crunch, Yum!");
	}
	
}
