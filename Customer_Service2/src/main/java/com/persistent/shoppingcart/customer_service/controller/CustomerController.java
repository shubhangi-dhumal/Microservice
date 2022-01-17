package com.persistent.shoppingcart.customer_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.shoppingcart.customer_service.model.Customer;
import com.persistent.shoppingcart.customer_service.repository.CustomerRepository;
import com.persistent.shoppingcart.customer_service.service.CustomerService;
import com.persistent.shoppingcart.customer_service.valueobject.ResponseTemplateVO;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	/*
	 * @GetMapping("/{id}") public ResponseTemplateVO
	 * getCustomerWithProduct(@PathVariable("id") Long customerId) {
	 * ResponseTemplateVO customerWithProduct =
	 * customerService.getCustomerWithProduct(customerId);
	 * 
	 * return customerWithProduct;
	 * 
	 * 
	 * }
	 */

// Get Customer Details
	@GetMapping("/{id}")
	public ResponseEntity<ResponseTemplateVO> getCustomerWithProduct(@PathVariable("id") Long customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
                //return new ResponseEntity<ResponseTemplateVO>("Customer not Found", HttpStatus.NOT_FOUND);
			return ResponseEntity.notFound().build();
		} else {
			ResponseTemplateVO vo = customerService.getCustomerWithProduct(customerId);
			return new ResponseEntity<ResponseTemplateVO>(vo, HttpStatus.OK);
		}
	}

	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Long customerId) {

		Customer theCustomer = customerRepository.findByCustomerId(customerId);
		if (theCustomer == null) {
			return new ResponseEntity<String>("Customer Id not found :" + customerId, HttpStatus.BAD_REQUEST);
		} else {
			customerService.deleteCustomer(customerId);
			return new ResponseEntity<String>("Customer Deleted Successfully", HttpStatus.OK);
		}

	}

}
