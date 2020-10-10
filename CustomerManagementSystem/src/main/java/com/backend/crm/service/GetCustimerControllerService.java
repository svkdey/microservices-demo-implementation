package com.backend.crm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.backend.crm.controller.GetCustomerRes;
import com.backend.crm.models.Customer;
import com.backend.crm.service.Impl.GetCustomerControllerServiceImpl;

@RestController
public class GetCustimerControllerService implements GetCustomerRes {

	@Autowired
	private GetCustomerControllerServiceImpl getCustomerControllerServiceImpl;
	
	@Override
	public Customer getCustomer(String id) throws Exception {
			System.out.println(id);
		try {
			Optional<Customer> res=getCustomerControllerServiceImpl.getCustomer(id);

			return res.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage(),e.getCause());
		}
	}
}
