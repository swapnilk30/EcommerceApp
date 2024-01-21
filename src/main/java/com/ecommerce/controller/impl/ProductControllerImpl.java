package com.ecommerce.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.ProductController;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.service.ProductService;

@RestController
public class ProductControllerImpl implements ProductController {
	
	@Autowired
	private ProductService productService;

	@Override
	public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
		ProductDto createProduct = productService.createProduct(productDto);
		return new ResponseEntity<>(createProduct,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ProductDto> updateProduct(String productId, ProductDto productDto) {
		ProductDto updateProduct = productService.updateProduct(productId, productDto);
		return ResponseEntity.ok(updateProduct);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> deleteProduct(String productId) {
		productService.deleteProduct(productId);
		ApiResponseMessege response=new ApiResponseMessege("Product Deleted Successfully",HttpStatus.OK);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ProductDto> getProductById(String productId) {
		ProductDto dto = productService.getById(productId);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<List<ProductDto>> getAll() {
		List<ProductDto> productDtos = productService.getAll();
		return ResponseEntity.ok(productDtos);
	}

	@Override
	public ResponseEntity<List<ProductDto>> searchProductByTile(String title) {
		List<ProductDto> searchByTiltle = productService.searchByTiltle(title);
		return ResponseEntity.ok(searchByTiltle);
	}

}
