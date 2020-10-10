package com.backend.billingManagemenetService.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.billingManagemenetService.model.TransactionDetails;



@RequestMapping("/billing-api")
@RefreshScope
public interface BuyProductRes {
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public TransactionDetails createCustomer(@RequestBody TransactionDetails transaction) throws Exception ;
}
