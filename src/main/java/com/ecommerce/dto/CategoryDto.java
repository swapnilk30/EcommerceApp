package com.ecommerce.dto;

public class CategoryDto {

	private String categoryId;

	private String title;

	private String description;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CategoryDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public CategoryDto() {
		// TODO Auto-generated constructor stub
	}

}
