package com.backend.crm.repo;

import org.springframework.data.repository.CrudRepository;

import com.backend.crm.models.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String> {

}
