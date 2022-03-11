/**
 * 
 */
package com.programming.techie.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.programming.techie.productservice.model.Product;
import com.programming.techie.productservice.repository.ProductRepository;

//import lombok.RequiredArgsConstructor;

/**
 * @author anees
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private final ProductRepository productRepo;
	
	private ProductController(ProductRepository productRepo) {
		this.productRepo = productRepo;
	} 
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> finadAll() {
		logger.info("<---------------------Request Body for Get_METHOD-------------------->");
		return productRepo.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		logger.info("<---------------------Request Body for Post_METHOD-------------------->");
		logger.info(product.toString());
		productRepo.save(product);
	}
}
