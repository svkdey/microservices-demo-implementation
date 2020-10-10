package com.backend.crm.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crm.models.Customer;
import com.backend.crm.repo.CustomerRepo;

@Service
public class CreateCustomerControllerServiceImpl {
	@Autowired
	private CustomerRepo repo;
	public Customer addCustomer(Customer customer) throws Exception {
		try {
			return repo.save(customer);
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e.getCause());
		}
	}
}
