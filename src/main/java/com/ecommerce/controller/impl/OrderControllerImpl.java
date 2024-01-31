package com.ecommerce.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.OrderController;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.CreateOrderRequest;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.service.OrderService;

@RestController
public class OrderControllerImpl implements OrderController{

	@Autowired
	private OrderService orderService;
	
	@Override  
	public ResponseEntity<OrderDto> createOrder(CreateOrderRequest orderRequest) {
		OrderDto createOrder = orderService.createOrder(orderRequest);
		return new ResponseEntity<OrderDto>(createOrder,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> removeOrder(String orderId) {
		orderService.removeOrder(orderId);
		ApiResponseMessege responseMessege = new ApiResponseMessege("order is removed !!",HttpStatus.OK);
		return ResponseEntity.ok(responseMessege);
	}

	@Override
	public ResponseEntity<List<OrderDto>> getOrdersOfUser(String userId) {
		List<OrderDto> orderOfUser = orderService.getOrderOfUser(userId);
		return ResponseEntity.ok(orderOfUser);
	}

	@Override
	public ResponseEntity<List<OrderDto>> getAllOrders() {
		List<OrderDto> orders = orderService.getOrders();
		return ResponseEntity.ok(orders);
	}
	
	
	
	

}
