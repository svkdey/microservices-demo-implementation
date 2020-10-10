package com.backend.billingManagemenetService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.backend.billingManagemenetService.controller.GetCustomerCharges;
import com.backend.billingManagemenetService.model.ImplGetCustomerResponse;
import com.backend.billingManagemenetService.model.TransactionDetails;
import com.backend.billingManagemenetService.service.impl.GetCustomerChargesImpl;

@RestController
public class GetCustomerChargesControllerService implements GetCustomerCharges {

	@Autowired
	private GetCustomerChargesImpl getCustomerChargesImpl;

	@Override
	public ImplGetCustomerResponse getCustomerCharges(String id) throws Exception {
		ImplGetCustomerResponse list=new ImplGetCustomerResponse();
		try {
			List<TransactionDetails> res = getCustomerChargesImpl.getBills(id);
			list.setCustomerList(res);
			return list;

		} catch (Exception e) {
			throw new Exception(e.getMessage(), e.getCause());
		}
	}

}
