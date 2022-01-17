package com.persistent.shoppingcart.customer_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.persistent.shoppingcart.customer_service.model.Customer;
import com.persistent.shoppingcart.customer_service.repository.CustomerRepository;
import com.persistent.shoppingcart.customer_service.valueobject.Product;
import com.persistent.shoppingcart.customer_service.valueobject.ResponseTemplateVO;


@Service
public class CustomerService
{
    @Autowired
	private CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;
    
	public Customer saveCustomer(Customer customer) 
	{
	   return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	public ResponseTemplateVO getCustomerWithProduct(Long customerId)
	{
	   ResponseTemplateVO vo= new ResponseTemplateVO();
	   Customer customer = customerRepository.findByCustomerId(customerId);
       
	  // Cart cart =restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + customer.getProductId(),Product.class);
	   
	   //Calling Account microservice to get account details
	   
	   //for()
	   //{
	   Product product = 
			   restTemplate.getForObject("http://PRODUCT-SERVICE/products/" + customer.getProductId(),Product.class);
	   //List<Product> list.add();
	  // }
	   //To set user and department in VO 
	   vo.setCustomer(customer);
	   vo.setProduct(product);
	   
       return vo;	
	}
   
}
