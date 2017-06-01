package com.techelevator.view;

public class VendingMachineItem {
	private String itemName;
	private double itemPrice;
	private int itemsRemaining;
	
	public VendingMachineItem(String name, double price, int itemsRemaining) {
		this.itemName = name;
		this.itemPrice = price;
		this.itemsRemaining = itemsRemaining;
	}
	public String getItemName() {
		return itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	
	public int getItemsRemaining() {
		return itemsRemaining;
	}
	
	public int setItemsRemaining(int itemsRemaining) {
		return this.itemsRemaining = itemsRemaining;
	}
	
	public void makeNoise() {
		System.out.println("Cool!");
	}
	
	@Override
	public String toString() {
		return getItemName() + " $" + getItemPrice() + " " + getItemsRemaining() + " Remaining";
	}
	
	
}
