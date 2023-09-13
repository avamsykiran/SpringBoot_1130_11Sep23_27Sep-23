package com.cts.sbdd.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.sbdd.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	boolean existsByMobileNumber(String mobileNumber);

	Optional<Customer> findByMobileNumber(String mobileNumber);

	List<Customer> findAllByFullName(String fullName);

	@Query("SELECT c FROM Customer WHERE c.registrationDate BETWEEN :start AND :end")
	List<Customer> extractCustoemrRegistedBetween(LocalDate start, LocalDate end);

}
