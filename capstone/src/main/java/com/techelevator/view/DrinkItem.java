package com.techelevator.view;

public class DrinkItem extends VendingMachineItem {

	public DrinkItem(String name, double price, int itemsRemaining, int itemSold) {
		super(name, price, itemsRemaining, itemSold);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Glug Glug, Yum!");
	}

}
