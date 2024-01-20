package com.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.UserDto;

@RequestMapping("/users")
public interface UserController {

	
	@PostMapping  // POST  http://localhost:8085/users
	UserDto createUser(@RequestBody UserDto userDto);
	
	@GetMapping // GET  http://localhost:8085/users
	List<UserDto> getAllUser();
	
	@GetMapping("/{userId}") //GET  http://localhost:8085/users/3
	ResponseEntity<UserDto> getUserById(@PathVariable String userId);
	
	@DeleteMapping("/{userId}") //DELETE  http://localhost:8085/users/3
	ResponseEntity<ApiResponseMessege> deleteUserById(@PathVariable String userId);
   
	@PutMapping("/{userId}")   // UPDATE   http://localhost:8085/users/3
	ResponseEntity<UserDto> updateUser(@PathVariable String userId,@RequestBody UserDto userDto);
	
	@PatchMapping("/{userId}")  // PATCH   http://localhost:8085/users/3?password=kasldh
	ResponseEntity<UserDto> changePassword(@PathVariable String userId,@RequestParam("password") String password);
}
