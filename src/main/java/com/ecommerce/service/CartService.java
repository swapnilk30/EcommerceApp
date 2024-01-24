package com.ecommerce.service;

import com.ecommerce.dto.AddItemToCartRequest;
import com.ecommerce.dto.CartDto;


public interface CartService {
	
	//add items to cart
	
	//case1 cart for user is not avialble : we will create cart and then add items
	
	//case2 : cart available add items to cart

	
	CartDto addItemToCart(String userId,AddItemToCartRequest request);
	
	//remove items from cart
	
	void removeItemFromCart(String userId,int cartItemId);
	
	// remove all items from cart
	void clearCart(String userId);
	
	
	CartDto getCartByUser(String userId);

}
