package com.ecommerce.service.impl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.AddItemToCartRequest;
import com.ecommerce.dto.CartDto;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.exception.BadApiRequestException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.CartService;

@Service
public class CartServieImpl implements CartService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public CartDto addItemToCart(String userId, AddItemToCartRequest request) {
		String productId = request.getProductId();
		int quantity = request.getQuantity();

		if (quantity <= 0) {
			throw new BadApiRequestException("Requested quantity is not valid !!");
		}

		// fetch the product
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found In DataBase !!"));

		// fetch User from db
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found !!"));

		Cart cart = null;
		try {
			cart = cartRepository.findByUser(user).get();
		} catch (NoSuchElementException e) {
			cart = new Cart();
			cart.setCartId(UUID.randomUUID().toString());
			cart.setCreatedAt(new Date());
		}
		// perform cart operation
		// if cart item already present then update
		AtomicReference<Boolean> updated = new AtomicReference<>(false);
		List<CartItem> items = cart.getItems();
		List<CartItem> updatedItems = items.stream().map(item -> {
			if (item.getProduct().getProductId().equals(productId)) {
				// item already present in cart
				item.setQuantity(quantity);
				item.setTotalPrice(quantity * product.getPrice());
				updated.set(true);

			}
			return item;
		}).collect(Collectors.toList());

		cart.setItems(updatedItems);

		// create items
		if (!updated.get()) {
			CartItem cartItem = CartItem.builder().quantity(quantity).totalPrice(quantity * product.getPrice())
					.cart(cart).product(product).build();

			cart.getItems().add(cartItem);
		}

		cart.setUser(user);

		Cart updatedCart = cartRepository.save(cart);

		return mapper.map(updatedCart, CartDto.class);
	}

	@Override
	public void removeItemFromCart(String userId, int cartItemId) {
		CartItem cartItem1 = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Cart item not found !!"));
		cartItemRepository.delete(cartItem1);
	}

	@Override
	public void clearCart(String userId) {
		// fetch User from db
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found !!"));

		Cart cart = cartRepository.findByUser(user)
				.orElseThrow(() -> new ResourceNotFoundException("Cart of given User Not Found!!"));

		cart.getItems().clear();

		cartRepository.save(cart);

	}

	@Override
	public CartDto getCartByUser(String userId) {
		// fetch User from db
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found !!"));

		Cart cart = cartRepository.findByUser(user)
				.orElseThrow(() -> new ResourceNotFoundException("Cart of given User Not Found!!"));

		return mapper.map(cart, CartDto.class);
	}

}
