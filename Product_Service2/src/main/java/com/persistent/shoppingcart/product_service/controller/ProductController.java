package com.persistent.shoppingcart.product_service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.persistent.shoppingcart.product_service.model.Product;
import com.persistent.shoppingcart.product_service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController 
{
  @Autowired	
  private ProductService productService;
  
  @PostMapping("/")
  public Product saveProduct(@RequestBody Product product)
  {
	return productService.saveProduct(product); 
  }
  
   //getProductInfo
  @GetMapping("/{productId}")
  public ResponseEntity<Product> findProductById(@PathVariable("productId") int productId)
  {
		/*
		 * Product theProduct=productService.findByProductId(productId); if
		 * (theProduct==null) { return ResponseEntity.notFound().build();
		 * 
		 * } else { //productService.deleteProduct(productId); return new
		 * ResponseEntity<Product>(theProduct,HttpStatus.OK); }
		 */
	  
	 return Optional
      .ofNullable( productService.findByProductId(productId) )
      .map( product -> ResponseEntity.ok().body(product) )          //200 OK
      .orElseGet( () -> ResponseEntity.notFound().build() );  //404 Not found
   }  
	  
  
  
  // check price
	@GetMapping("/{productId}/price")
	public ResponseEntity<Integer> getPrice(@PathVariable("productId") int productId) 
	{
		 
		Integer price = productService.getPrice(productId); 
	   	
		return new ResponseEntity<Integer>(price,HttpStatus.OK);
	}  
	
	//update price
		@PutMapping("/{productId}/update/{price}")
		public ResponseEntity<String> updatePriceByProductId(@PathVariable int productId, @PathVariable int price)
		{
			Product theProduct=productService.findByProductId(productId);
	 	      if (theProduct==null)
	 	      {
	 			 return new  ResponseEntity<String>("Product Id not found :"+productId,HttpStatus.BAD_REQUEST);
	 		  }
	 	      else
	 	      {			
			          productService.updatePriceByProductId(productId, price);
		       				return new ResponseEntity<String>("price updated Successfully !!",HttpStatus.OK);
		      }
		}
		
		// delet/0o\ product
	    @DeleteMapping("/{productId}")
		public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) 
		{
	    	Product theProduct=productService.findByProductId(productId);
	 	      if (theProduct==null)
	 	      {
	 			 return new  ResponseEntity<String>("Product Id not found :"+productId,HttpStatus.BAD_REQUEST);
 	 		  }
	 	     else
	 	      {
	 	    
           			productService.deleteProduct(productId);
			       return new ResponseEntity<String>("Product Deleted Successfully",HttpStatus.OK);
		 	    }
		}

	    
	    
	    

}
