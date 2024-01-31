package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.CreateOrderRequest;
import com.ecommerce.dto.OrderDto;

@RequestMapping("/orders")
public interface OrderController {

	// create
	@PostMapping
	ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequest orderRequest);

	//
	@DeleteMapping("/{orderId}")
	ResponseEntity<ApiResponseMessege> removeOrder(@PathVariable String orderId);

	// get orders of the user
	@GetMapping("/users/{userId}")
	ResponseEntity<List<OrderDto>> getOrdersOfUser(@PathVariable String userId);

	// get all orders
	@GetMapping
	ResponseEntity<List<OrderDto>> getAllOrders();

}
