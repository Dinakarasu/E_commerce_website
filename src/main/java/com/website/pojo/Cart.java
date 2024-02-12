package com.website.pojo;

public class Cart extends ProductDetails{
	private int quantity;
	private double totalprice;
	
	public Cart() {
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalprice;
	}
	public void setTotalPrice(double totalprice) {
		this.totalprice = totalprice;
	}
}
