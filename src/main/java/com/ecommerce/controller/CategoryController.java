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
import com.ecommerce.dto.CategoryDto;

@RequestMapping("/categories")
public interface CategoryController {
	
	//create  POST http://localhost:8085/categories
	@PostMapping
	ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto);
	
	
	//update	PUT http://localhost:8085/categories/3
	@PutMapping("/{categoryId}")
	ResponseEntity<CategoryDto> updateCategory(@PathVariable String categoryId,@RequestBody CategoryDto categoryDto);
	
	//delete	DELETE http://localhost:8085/categories/3
	@DeleteMapping("/{categoryId}")
	ResponseEntity<ApiResponseMessege> deleteCategory(@PathVariable String categoryId);
	
	//get All 	GET http://localhost:8085/categories
	@GetMapping
	ResponseEntity<List<CategoryDto>> getAllCategory();
	
	//get by id		GET http://localhost:8085/categories/3
	@GetMapping("/{categoryId}")
	ResponseEntity<CategoryDto> getCategoryById(@PathVariable String categoryId);
	
	//get by title 	GET http://localhost:8085/categories/title/elctronics
	@GetMapping("/title/{title}")
	ResponseEntity<CategoryDto> getCategoryByTitle(@PathVariable String title);
	

}
