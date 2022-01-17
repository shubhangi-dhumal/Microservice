package com.persistent.shoppingcart.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.shoppingcart.customer_service.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>, CrudRepository<Customer, Long>
{

		Customer findByCustomerId(Long customerId);

}
