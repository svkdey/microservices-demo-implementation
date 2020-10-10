package com.backend.crm.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.crm.models.Customer;

@RequestMapping("/customer-api")
@RefreshScope
public interface CreateCustomerRes {
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer createCustomer(@RequestBody Customer customer) throws Exception;
}
