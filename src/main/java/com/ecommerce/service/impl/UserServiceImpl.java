package com.ecommerce.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.UserDto;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		//Generate random userId
		String userId = UUID.randomUUID().toString();
		userDto.setUserId(userId);
		//Convert UserDto to User Entity
		User user = dtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		//Convert UserEntity to UserDto
		UserDto newUserDto = entityToDto(savedUser);
		return newUserDto;
	}
 
// Method creation for UserDto to Entity
	private User dtoToEntity(UserDto userDto) {
		User user=new User();
		user.setUserId(userDto.getUserId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
		
		
	}

	 private UserDto entityToDto(User savedUser) {
		  UserDto userDto=new UserDto();
		   
		  userDto.setUserId(savedUser.getUserId());
		  userDto.setName(savedUser.getName());
		  userDto.setEmail(savedUser.getEmail());
		  userDto.setPassword(savedUser.getPassword());
		  return userDto;
			
			
		}

}
