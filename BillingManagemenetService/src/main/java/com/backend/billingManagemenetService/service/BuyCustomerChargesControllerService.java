package com.backend.billingManagemenetService.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.backend.billingManagemenetService.controller.BuyProductRes;
import com.backend.billingManagemenetService.model.TransactionDetails;
import com.backend.billingManagemenetService.service.impl.BuyProductResImpl;

@RestController
public class BuyCustomerChargesControllerService implements BuyProductRes {
	

	@Autowired
	private BuyProductResImpl buyProductResImpl;

	@Override
	public TransactionDetails createCustomer(TransactionDetails transaction) throws Exception {
		transaction.setTransactionId(UUID.randomUUID().toString());
		try {
			TransactionDetails res = buyProductResImpl.addTransaction(transaction);
			return res;
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e.getCause());
		}
	}

}
