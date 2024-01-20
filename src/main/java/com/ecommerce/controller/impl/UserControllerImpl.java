package com.ecommerce.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.controller.UserController;
import com.ecommerce.dto.ApiResponseMessege;
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

	@Override
	public List<UserDto> getAllUser() {
		List<UserDto> allUserDtoList = userService.getAllUser();
		return allUserDtoList;
	}

	@Override
	public ResponseEntity<UserDto> getUserById(String userId) {
		UserDto userDto1=userService.getUserById(userId);
		return new ResponseEntity<>(userDto1,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> deleteUserById(String userId) {
		userService.deleteUserById(userId);
		ApiResponseMessege responseMessege = new ApiResponseMessege("User is Deleted Successfully !!",HttpStatus.OK);
		return ResponseEntity.ok(responseMessege);
	}

}
