package com.persistent.shoppingcart.product_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.shoppingcart.product_service.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{

	Product findByProductId(int productId);

	@Query("select price from Product where productId = ?1")
	public int findPriceByProductId(int productId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Product set price=?2 where productId=?1")
	public void updatePriceByProductId(int productId, int price);

}
