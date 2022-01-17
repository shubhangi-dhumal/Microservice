package com.persistent.shoppingcart.customer_service.valueobject;

public class Product {
	private int productId;
	private String productName;
	private String category;
	private int price;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String category, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}