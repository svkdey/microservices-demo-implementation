package com.backend.crm.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
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
	
	
}
