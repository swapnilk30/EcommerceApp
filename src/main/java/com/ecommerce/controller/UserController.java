package com.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.dto.UserDto;

@RequestMapping("/users")
public interface UserController {

	
	@PostMapping  //http://localhost:8085/users
	UserDto createUser(@RequestBody UserDto userDto);
}
