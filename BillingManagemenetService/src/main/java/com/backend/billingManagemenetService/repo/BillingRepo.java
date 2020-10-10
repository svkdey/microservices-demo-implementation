package com.backend.billingManagemenetService.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.backend.billingManagemenetService.model.TransactionDetails;



public interface BillingRepo extends CrudRepository<TransactionDetails, String> {
	List<TransactionDetails> findAllByBillingAccountId(String id);
}
