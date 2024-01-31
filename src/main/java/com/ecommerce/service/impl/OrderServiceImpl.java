package com.ecommerce.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CreateOrderRequest;
import com.ecommerce.dto.OrderDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.User;
import com.ecommerce.exception.BadApiRequestException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CartRepository cartRepository;

	@Override
	public OrderDto createOrder(CreateOrderRequest orderDto) {

		String userId = orderDto.getUserId();

		String cartId = orderDto.getCartId();

		// fetch user
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given id !!"));

		// fetch cart
		Cart cart = cartRepository.findById(cartId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart Not Found With given Id !!"));

		List<CartItem> cartItems = cart.getItems();

		if (cartItems.size() <= 0) {
			throw new BadApiRequestException("Invalid number of items in cart !!");
		}

		Order order = Order.builder().billingName(orderDto.getBillingName())
				.billingAddress(orderDto.getBillingAddress()).billingPhone(orderDto.getBillingPhone())
				.orderedDate(new Date()).deliveredDate(null).paymentStatus(orderDto.getPaymentStatus())
				.orderStatus(orderDto.getOrderStatus()).orderId(UUID.randomUUID().toString()).user(user).build();

		AtomicReference<Double> orderAmount = new AtomicReference<>(0.0);

		List<OrderItem> orderItems = cartItems.stream().map(cartItem -> {
			// cartItem -> orderItem
			OrderItem orderItem = OrderItem.builder().quantity(cartItem.getQuantity()).product(cartItem.getProduct())
					.totalPrice(cartItem.getTotalPrice()).order(order).build();

			orderAmount.set(orderAmount.get() + orderItem.getTotalPrice());
			return orderItem;
		}).collect(Collectors.toList());

		order.setOrderItems(orderItems);
		order.setOrderAmount(orderAmount.get());

		//
		cart.getItems().clear();
		cartRepository.save(cart);

		Order savedOrder = orderRepository.save(order);

		return mapper.map(savedOrder, OrderDto.class);
	}

	@Override
	public void removeOrder(String orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("order not found !!"));

		orderRepository.delete(order);

	}

	@Override
	public List<OrderDto> getOrderOfUser(String userId) {

		// fetch user
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with given id !!"));

		List<Order> orders = orderRepository.findByUser(user);
		
		List<OrderDto> orderDtos = orders.stream().map(order -> mapper.map(order,OrderDto.class)).collect(Collectors.toList());
		return orderDtos;
	}

	@Override
	public List<OrderDto> getOrders() {
		List<Order> orders = orderRepository.findAll();
		List<OrderDto> orderDtos = orders.stream().map(order -> mapper.map(order,OrderDto.class)).collect(Collectors.toList());
		return orderDtos;
	}

}
