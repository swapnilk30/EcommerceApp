package com.ecommerce.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.CategoryController;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.CategoryDto;
import com.ecommerce.service.CategoryService;

@RestController
public class CategoryControllerImpl implements CategoryController{
	
	@Autowired
	private CategoryService categoryService;

	@Override
	public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return ResponseEntity.ok(createCategory);
	}

	@Override
	public ResponseEntity<CategoryDto> updateCategory(String categoryId, CategoryDto categoryDto) {
		CategoryDto updateCategory = categoryService.updateCategory(categoryId, categoryDto);
		return ResponseEntity.ok(updateCategory);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> deleteCategory(String categoryId) {
		categoryService.deleteCategory(categoryId);
		ApiResponseMessege responseMessege = new ApiResponseMessege("Category is Deleted Successfully !!",HttpStatus.OK);
		return ResponseEntity.ok(responseMessege);
	}

	@Override
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		List<CategoryDto> allCategory = categoryService.getAllCategory();
		return ResponseEntity.ok(allCategory);
	}

	@Override
	public ResponseEntity<CategoryDto> getCategoryById(String categoryId) {
		CategoryDto categoryById = categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(categoryById);
	}

	@Override
	public ResponseEntity<CategoryDto> getCategoryByTitle(String title) {
		CategoryDto categoryByTitle = categoryService.getCategoryByTitle(title);
		return ResponseEntity.ok(categoryByTitle);
	}

}
