package com.backend.billingManagemenetService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.billingManagemenetService.model.TransactionDetails;
import com.backend.billingManagemenetService.repo.BillingRepo;
@Service
public class GetCustomerChargesImpl {
	@Autowired
	private BillingRepo repo;
	
	public List<TransactionDetails> getBills(String id) throws Exception {
		
		try {
			return repo.findAllByBillingAccountId(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e.getCause());
		}
	}
}
