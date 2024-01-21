package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDto;

public interface ProductService {
	
	//Create product
	ProductDto createProduct(ProductDto productDto);
	
	//Update product By id
	ProductDto updateProduct(String productId,ProductDto productDto);
	
	//Delete Product By id
	void deleteProduct(String productId);
	
	//Get Product By id
	ProductDto getById(String productId);
	
	//get All Product
	List<ProductDto> getAll();
	
	//Search product
	List<ProductDto> searchByTiltle(String title);

}
