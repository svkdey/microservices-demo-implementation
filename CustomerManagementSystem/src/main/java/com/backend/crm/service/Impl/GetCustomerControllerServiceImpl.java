package com.backend.crm.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crm.models.Customer;
import com.backend.crm.repo.CustomerRepo;
@Service
public class GetCustomerControllerServiceImpl {
	@Autowired
	private CustomerRepo repo;
	public Optional<Customer> getCustomer(String id) throws Exception {
		try {
			return repo.findById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e.getCause());
		}
	}
}
