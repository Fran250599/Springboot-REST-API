package com.francisco.crud;

import com.francisco.crud.controller.ProductController;
import com.francisco.crud.model.Product;
import com.francisco.crud.repository.ProductRepository;
import com.francisco.crud.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	// CRUD tests
	@Test
	void registerProduct(){
		// Create a product
		Product product = new Product();
		product.setName("Test");
		product.setPrice(1000);
		product.setStock(10);
		productRepository.save(product);

	}
}
