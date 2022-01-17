package com.persistent.shoppingcart.product_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.shoppingcart.product_service.model.Product;
import com.persistent.shoppingcart.product_service.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
    private ProductRepository productRepository;

     //save Details
	public Product saveProduct(Product product)
	{
	  return productRepository.save(product);  
	}

	//Get ProductDetails
	public Product findByProductId(int productId) 
	{
	   return productRepository.findByProductId(productId);
	}
	
	//Get price
	public int getPrice(int productId) {
		return productRepository.findPriceByProductId(productId);
	}
	
	//Update price
	public void updatePriceByProductId(int productId, int price) {
		productRepository.updatePriceByProductId(productId, price);
	}
	
	//Delete Product
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}
}
