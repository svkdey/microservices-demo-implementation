package com.backend.billingManagemenetService.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.billingManagemenetService.model.TransactionDetails;
import com.backend.billingManagemenetService.repo.BillingRepo;
@Service
public class BuyProductResImpl {
	@Autowired
	private BillingRepo repo;
	public TransactionDetails addTransaction(TransactionDetails transaction) throws Exception {
		try {
			return repo.save(transaction);
		} catch (Exception e) {	
			throw new Exception(e.getMessage(),e.getCause());
		}
	}
}
