package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.User;

public interface OrderRepository extends JpaRepository<Order,String>{

	
	List<Order> findByUser(User user);
	
}
