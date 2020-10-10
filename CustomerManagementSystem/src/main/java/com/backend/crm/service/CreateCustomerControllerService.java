package com.backend.crm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.backend.crm.controller.CreateCustomerRes;
import com.backend.crm.models.Customer;
import com.backend.crm.service.Impl.CreateCustomerControllerServiceImpl;


@RestController
public class CreateCustomerControllerService implements CreateCustomerRes{

	
	@Autowired
	private CreateCustomerControllerServiceImpl createCustomerControllerService;
	@Override
	public Customer createCustomer(Customer customer) throws Exception {
		String id=UUID.randomUUID().toString();
		String billingAccount=UUID.randomUUID().toString();
		customer.setCustomerId(id);
		customer.setBillingAccount(billingAccount);
		try {
		Customer res=createCustomerControllerService.addCustomer(customer);
		return res;
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e.getCause()); 
		}
	}

}
