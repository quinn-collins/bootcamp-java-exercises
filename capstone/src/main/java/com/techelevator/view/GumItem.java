package com.techelevator.view;

public class GumItem extends VendingMachineItem{

	public GumItem(String name, double price, int itemsRemaining, int itemSold) {
		super(name, price, itemsRemaining, itemSold);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Chew Chew, Yum!");
	}

}
