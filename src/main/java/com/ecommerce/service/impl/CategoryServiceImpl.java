package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CategoryDto;
import com.ecommerce.entity.Category;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		// generate random catgoryId
		String categoryId = UUID.randomUUID().toString();
		categoryDto.setCategoryId(categoryId);
		// convert categoryDto to entity
		Category category = mapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepository.save(category);
		return mapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(String categoryId, CategoryDto categoryDto) {
		// get Category by id
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found BY Given Id !!"));

		// update category
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());

		// save
		Category updatedCategory = categoryRepository.save(category);

		return mapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(String categoryId) {
		// get Category by id
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found BY Given Id !!"));
		//delete Category by id
		categoryRepository.delete(category);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();
		
		List<CategoryDto> categorydtos = new ArrayList<>();
		for(Category category : categories) {
			categorydtos.add(mapper.map(category, CategoryDto.class));
		}
		return categorydtos;
	}

	@Override
	public CategoryDto getCategoryById(String categoryId) {
		// get Category by id
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found BY Given Id !!"));
		return mapper.map(category, CategoryDto.class);
	}

	
	
	@Override
	public CategoryDto getCategoryByTitle(String title) {
		Category category=categoryRepository.findByTitle(title);
		return mapper.map(category, CategoryDto.class);
	}

}
