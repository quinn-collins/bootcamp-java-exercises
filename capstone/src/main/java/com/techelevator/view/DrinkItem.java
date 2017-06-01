package com.techelevator.view;

public class DrinkItem extends VendingMachineItem {

	public DrinkItem(String name, double price, int itemsRemaining) {
		super(name, price, itemsRemaining);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Glug Glug, Yum!");
	}

}
