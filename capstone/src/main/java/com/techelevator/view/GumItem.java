package com.techelevator.view;

public class GumItem extends VendingMachineItem{

	public GumItem(String name, double price, int itemsRemaining) {
		super(name, price, itemsRemaining);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Chew Chew, Yum!");
	}

}
