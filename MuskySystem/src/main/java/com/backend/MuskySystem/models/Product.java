package com.backend.MuskySystem.models;

import java.io.Serializable;

public class Product 	implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String product;
	private double amount;
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
