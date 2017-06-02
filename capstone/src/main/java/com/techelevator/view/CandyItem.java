package com.techelevator.view;

public class CandyItem extends VendingMachineItem {

	public CandyItem(String name, double price, int itemsRemaining, int itemSold) {
		super(name, price, itemsRemaining, itemSold);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Munch Munch, Yum!");
	}

}
