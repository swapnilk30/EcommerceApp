package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dto.UserDto;

@RequestMapping("/users")
public interface UserController {

	
	@PostMapping  // POST  http://localhost:8085/users
	UserDto createUser(@RequestBody UserDto userDto);
	
	@GetMapping // GET  http://localhost:8085/users
	List<UserDto> getAllUser();
	
	@GetMapping("/{userId}") //GET  http://localhost:8085/users/3
	ResponseEntity<UserDto> getUserById(@PathVariable String userId);
}
