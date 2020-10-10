package com.backend.MuskySystem.dto;

import java.util.List;

public class ImplGetCustomerResponse {
	private List<TransactionDetails> trasactionList ;

	public List<TransactionDetails> getCustomerList() {
		return trasactionList;
	}

	public void setCustomerList(List<TransactionDetails> customerList) {
		this.trasactionList = customerList;
	}

	@Override
	public String toString() {
		return "ImplGetCustomerResponse [customerList=" + trasactionList + "]";
	}

	
	
}
