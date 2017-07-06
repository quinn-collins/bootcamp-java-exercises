package com.techelevator.ssg.model.store;

public class shoppingCartItem {
	private Product product;
	private int quantity;
	private DollarAmount totalPrice;
	
	public DollarAmount getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(DollarAmount totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
