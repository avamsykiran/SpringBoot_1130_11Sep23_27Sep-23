package com.cts.sbdd.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.sbdd.entities.Customer;
import com.cts.sbdd.exceptions.CustomerNotFoundException;
import com.cts.sbdd.exceptions.InvalidCustomerDetailsException;
import com.cts.sbdd.repos.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custoemrRepo;

	@Override
	public Customer add(Customer customer) throws InvalidCustomerDetailsException {
		if(customer==null || (customer.getCustomerPNR()!=null && custoemrRepo.existsById(customer.getCustomerPNR()))) {
			throw new InvalidCustomerDetailsException("The custoemr object is not generated or is a duplicate entry");
		}
		return custoemrRepo.save(customer);
	}

	@Override
	public Customer update(Customer customer) throws CustomerNotFoundException {
		if(customer==null || customer.getCustomerPNR()==null || !custoemrRepo.existsById(customer.getCustomerPNR())) {
			throw new CustomerNotFoundException();
		}
		return custoemrRepo.save(customer);
	}

	@Override
	public void delete(long customerPNR) throws CustomerNotFoundException {
		if(!custoemrRepo.existsById(customerPNR)) {
			throw new CustomerNotFoundException();
		}
		custoemrRepo.deleteById(customerPNR);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custoemrRepo.findAll();
	}

	@Override
	public Customer getById(long customerPNR) throws CustomerNotFoundException {
		Optional<Customer> customer = custoemrRepo.findById(customerPNR);
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException();
		}
		return customer.get();
	}

}
