package com.backend.MuskySystem.dto;

public class Customer {
	
	private String customerId;
	private String name;
	private String password;
	private String email;
	private String billingAccount;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBillingAccount() {
		return billingAccount;
	}
	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", billingAccount=" + billingAccount + "]";
	}
	
	
}
