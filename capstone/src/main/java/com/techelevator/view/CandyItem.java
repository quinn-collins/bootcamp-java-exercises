package com.techelevator.view;

public class CandyItem extends VendingMachineItem {

	public CandyItem(String name, double price, int itemsRemaining) {
		super(name, price, itemsRemaining);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Munch Munch, Yum!");
	}

}
