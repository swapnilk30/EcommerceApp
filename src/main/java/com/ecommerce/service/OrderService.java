package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.CreateOrderRequest;
import com.ecommerce.dto.OrderDto;

public interface OrderService{
	
	//create order
	
	OrderDto createOrder(CreateOrderRequest orderDto);
	
	//remove order
	void removeOrder(String orderId);
	
	//get orders of user
	List<OrderDto> getOrderOfUser(String userId);
	
	// get orders
	List<OrderDto> getOrders();
	
	

}
