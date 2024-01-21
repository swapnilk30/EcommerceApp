package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.ProductDto;

@RequestMapping("/products")
public interface ProductController {
	
	
	//create product           CREATE  http://localhost:9090/products
	@PostMapping
	ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto );
	
	// update product by Id    UPDATE  http://localhost:9090/products/6
	@PutMapping("/{productId}")
	ResponseEntity<ProductDto> updateProduct(@PathVariable String productId,@RequestBody ProductDto productDto );
	
	// delete product by Id     DELETE  http://localhost:9090/products/6
	@DeleteMapping("/{productId}")
	ResponseEntity<ApiResponseMessege> deleteProduct(@PathVariable String productId);
	
	
	// get product by Id        GET   http://localhost:9090/products/6
	@GetMapping("/{productId}")
	ResponseEntity<ProductDto> getProductById(@PathVariable String productId);
	
	// get all product          GET  http://localhost:9090/products
	@GetMapping
	ResponseEntity <List<ProductDto>> getAll();
	
	// Search product by title  GET  http://localhost:9090/products/search/mobile
	@GetMapping("/search/{title}")
	ResponseEntity <List<ProductDto>> searchProductByTile(@PathVariable String title);
	
	

}
