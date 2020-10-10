package com.backend.billingManagemenetService.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.billingManagemenetService.model.ImplGetCustomerResponse;

@RequestMapping("/billing-api")
@RefreshScope
public interface GetCustomerCharges {
	
	@RequestMapping(value = "/bill/{id}", method = RequestMethod.GET)
	public ImplGetCustomerResponse getCustomerCharges(@PathVariable String id) throws Exception ;
}
