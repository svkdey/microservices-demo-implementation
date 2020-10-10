package com.backend.billingManagemenetService.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class TransactionDetails implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String transactionId;
	private String billingAccountId;
	private String productId;
	private double price;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getBillingAccountId() {
		return billingAccountId;
	}
	public void setBillingAccountId(String billingAccountId) {
		this.billingAccountId = billingAccountId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
