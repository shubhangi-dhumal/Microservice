package com.persistent.shoppingcart.customer_service.valueobject;

import com.persistent.shoppingcart.customer_service.model.Customer;

//this class is nothing but wrapper object which contains user and department both

// this class (ResponseTemplateVO) can be used as a return type, so that we can return user and its department

public class ResponseTemplateVO 
{
    private Customer customer;
    private Product product;
	
    public ResponseTemplateVO() {
		super();
	}

	public ResponseTemplateVO(Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
	
}
