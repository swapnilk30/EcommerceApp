package com.ecommerce.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.UserController;
import com.ecommerce.dto.UserDto;
import com.ecommerce.service.UserService;
@RestController
public class UserControllerImpl implements UserController {

	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		UserDto createUser = userService.createUser(userDto);
		return createUser;
	}

}
