package com.cts.sbdd.services;

import java.util.List;

import com.cts.sbdd.entities.Customer;
import com.cts.sbdd.exceptions.CustomerNotFoundException;
import com.cts.sbdd.exceptions.InvalidCustomerDetailsException;

public interface CustomerService {
	Customer add(Customer customer) throws InvalidCustomerDetailsException;
	Customer update(Customer customer) throws CustomerNotFoundException;
	void delete(long customerPNR) throws CustomerNotFoundException;
	List<Customer> getAllCustomers();
	Customer getById(long customerPNR) throws CustomerNotFoundException;
}
