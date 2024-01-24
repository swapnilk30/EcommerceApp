package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.User;

public interface CartRepository extends JpaRepository<Cart, String>{

	
	Optional<Cart> findByUser(User user);
}
