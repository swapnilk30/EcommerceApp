package com.ecommerce.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.User;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		// Generate random userId
		String userId = UUID.randomUUID().toString();
		userDto.setUserId(userId);
		// Convert UserDto to User Entity
		User user = dtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		// Convert UserEntity to UserDto
		UserDto newUserDto = entityToDto(savedUser);
		return newUserDto;
	}

// Method creation for UserDto to Entity
	private User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setImageName(userDto.getImageName());
		return user;

	}

	private UserDto entityToDto(User savedUser) {
		UserDto userDto = new UserDto();

		userDto.setUserId(savedUser.getUserId());
		userDto.setName(savedUser.getName());
		userDto.setEmail(savedUser.getEmail());
		userDto.setPassword(savedUser.getPassword());
		userDto.setImageName(savedUser.getImageName());
		return userDto;

	}

	@Override
	public List<UserDto> getAllUser() {
		// fetch all data from db UserEntity List
		List<User> userList = userRepository.findAll();

		// new List create and convert entity to dto and add to this list
		List<UserDto> dtoList = new ArrayList<>();

		for (User user : userList) {

			UserDto userDto = new UserDto();

			userDto.setUserId(user.getUserId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(user.getPassword());
			userDto.setImageName(user.getImageName());

			dtoList.add(userDto);
		}

		return dtoList;
	}

	@Override
	public UserDto getUserById(String userId) {
	//	User user = userRepository.findById(userId).get();
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found by Given Id !!"));
		UserDto userDto = entityToDto(user);
		return userDto;
	}

	@Override
	public void deleteUserById(String userId) {
		// get user by id
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found by Given Id !!"));
		//user delete
		userRepository.delete(user);
	}

	@Override
	public UserDto updateUser(String userId, UserDto userDto) {
		// Get user by Id
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found by Given Id !!"));
		//update user
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setImageName(userDto.getImageName());
		//save user to Database
		User updatedUser=userRepository.save(user);
		UserDto updatedDto = entityToDto(updatedUser);
		return updatedDto;
	}

	@Override
	public UserDto updatePasswordById(String userId, String password) {
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found by Given Id !!"));
		//Update password Only
		user.setPassword(password);
		User passwordChange = userRepository.save(user);
		return entityToDto(passwordChange);
	}

}
