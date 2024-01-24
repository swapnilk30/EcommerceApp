package com.ecommerce.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.CartController;
import com.ecommerce.dto.AddItemToCartRequest;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.CartDto;
import com.ecommerce.service.CartService;

@RestController
public class CartControllerImpl implements CartController{
	
	@Autowired
	private CartService cartService;

	@Override
	public ResponseEntity<CartDto> addItemToCart(String userId, AddItemToCartRequest request) {
		CartDto cartDto = cartService.addItemToCart(userId, request);
		return new ResponseEntity<CartDto>(cartDto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> removeItemFromCart(String userId, int itemId) {
		cartService.removeItemFromCart(userId, itemId);
		ApiResponseMessege response = new ApiResponseMessege("Item is removed !!",HttpStatus.OK);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> clearCart(String userId) {
		cartService.clearCart(userId);
		ApiResponseMessege response = new ApiResponseMessege("cart is cleared !!",HttpStatus.OK);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<CartDto> getCartByUser(String userId) {
		CartDto cartByUser = cartService.getCartByUser(userId);
		return ResponseEntity.ok(cartByUser);
	}

	
	
	
	
}
