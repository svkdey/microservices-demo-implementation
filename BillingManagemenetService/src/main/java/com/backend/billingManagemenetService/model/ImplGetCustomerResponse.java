package com.backend.billingManagemenetService.model;

import java.util.List;

public class ImplGetCustomerResponse {
	private List<TransactionDetails> trasactionList ;

	public List<TransactionDetails> getCustomerList() {
		return trasactionList;
	}

	public void setCustomerList(List<TransactionDetails> customerList) {
		this.trasactionList = customerList;
	}

	
	
}
