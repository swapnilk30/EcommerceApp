package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//upadte
	CategoryDto updateCategory(String categoryId,CategoryDto categoryDto);
	
	// delete
	void deleteCategory(String categoryId);
	
	//get all
	List<CategoryDto> getAllCategory();
	
	//get by id
	CategoryDto getCategoryById(String categoryId);
	
	//find by title
	CategoryDto getCategoryByTitle(String title);
	

}
