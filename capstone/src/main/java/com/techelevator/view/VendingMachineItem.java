package com.techelevator.view;

public class VendingMachineItem {
	private String itemName;
	private double itemPrice;
	private int itemsRemaining;
	private int itemSold;
	
	public VendingMachineItem(String name, double price, int itemsRemaining, int itemSold) {
		this.itemName = name;
		this.itemPrice = price;
		this.itemsRemaining = itemsRemaining;
		this.itemSold = itemSold;
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
	public int getItemSold(){
		return itemSold;
	}
	public int setItemSold(int itemSold){
		return this.itemSold = itemSold;
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
