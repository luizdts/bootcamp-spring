package com.bootcamp.catalog.tests;

import java.time.Instant;

import com.bootcamp.catalog.dto.ProductDTO;
import com.bootcamp.catalog.entities.Category;
import com.bootcamp.catalog.entities.Product;

public class Factory {
	
	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://image.image.com", Instant.parse("2022-09-07T16:28:00Z"));
		product.getCategories().add(createCategory());
		return product;
	}
	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
	
	public static Category createCategory() {
		return new Category(1L, "Electronics");
	}
}
