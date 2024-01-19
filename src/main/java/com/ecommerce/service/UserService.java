package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.UserDto;

public interface UserService {

	
	//Create User
	UserDto createUser(UserDto userDto);
	
	//get All User
	List<UserDto> getAllUser();
	
	// get User by Id
	UserDto getUserById(String userId);
}
