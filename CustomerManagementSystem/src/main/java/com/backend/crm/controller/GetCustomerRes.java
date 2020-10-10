package com.backend.crm.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.crm.models.Customer;

@RequestMapping("/customer-api")
@RefreshScope
public interface GetCustomerRes {
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable String id) throws Exception;
}

