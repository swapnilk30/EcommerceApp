package com.ecommerce.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private String productId;
	
	private String title;
	
	private String description;
	
	private double price;
	
	private int quantity;
	
	private Date addedDate;
}
