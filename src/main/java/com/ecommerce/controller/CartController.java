package com.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dto.AddItemToCartRequest;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.CartDto;

@RequestMapping("/carts")
public interface CartController {

	
	// add items to cart
	@PostMapping("/{userId}")
	ResponseEntity<CartDto> addItemToCart(@PathVariable String userId,@RequestBody AddItemToCartRequest request);
	
	
	@DeleteMapping("/{userId}/items/{itemId}")
	ResponseEntity<ApiResponseMessege> removeItemFromCart(@PathVariable String userId,@PathVariable int itemId);

	// clear cart
	@DeleteMapping("/{userId}")
	ResponseEntity<ApiResponseMessege> clearCart(@PathVariable String userId);
	
	//get cart
	@GetMapping("/{userId}")
	ResponseEntity<CartDto> getCartByUser(@PathVariable String userId);
	
}
