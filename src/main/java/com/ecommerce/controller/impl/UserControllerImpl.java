package com.ecommerce.controller.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.controller.UserController;
import com.ecommerce.dto.ApiResponseMessege;
import com.ecommerce.dto.ImageResponse;
import com.ecommerce.dto.UserDto;
import com.ecommerce.service.FileService;
import com.ecommerce.service.UserService;
@RestController
public class UserControllerImpl implements UserController {

	//import from org.slf4j
	private static final Logger log=LoggerFactory.getLogger(UserControllerImpl.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${user.profile.image.path}")
	private String imageUploadPath;
	
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
		log.info("start: UserControllerImpl ---> getUserById id is {}",userId);
		UserDto userDto1=userService.getUserById(userId);
		return new ResponseEntity<>(userDto1,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponseMessege> deleteUserById(String userId) {
		userService.deleteUserById(userId);
		ApiResponseMessege responseMessege = new ApiResponseMessege("User is Deleted Successfully !!",HttpStatus.OK);
		return ResponseEntity.ok(responseMessege);
	}

	@Override
	public ResponseEntity<UserDto> updateUser(String userId, UserDto userDto) {
		UserDto updateUser = userService.updateUser(userId, userDto);
		return ResponseEntity.ok(updateUser);
	}

	@Override
	public ResponseEntity<UserDto> changePassword(String userId, String password) {
		UserDto updatePasswordById = userService.updatePasswordById(userId, password);
		return ResponseEntity.ok(updatePasswordById);
	}

	@Override
	public ResponseEntity<ImageResponse> uploadUserImage(MultipartFile image, String userId) throws IOException {
		String imageName=fileService.uploadImage(image, imageUploadPath);
		
		UserDto userDto = userService.getUserById(userId);
		userDto.setImageName(imageName);
		
		UserDto userDto2 = userService.updateUser(userId, userDto);

		ImageResponse imageResponse = ImageResponse.builder().imageName(imageName).success(true).status(HttpStatus.CREATED).message("User Image Uploaded Succussfully").build();
		
		return new ResponseEntity<>(imageResponse,HttpStatus.CREATED);
	}

}
