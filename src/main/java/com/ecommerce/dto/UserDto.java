package com.ecommerce.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ecommerce.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private String userId; 

	@Size(min = 3,max = 15,message = "Invalid Name !!")
	private String name;

	//@Email(message = "Invalid User Email !!")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid User Email !!")
	private String email;

	@NotBlank(message = "Password is required !!")
	private String password;
	
	//@Size(min = 4,max =6,message = "Invalid gender !!")
	//private String gender;
	
	private String imageName;
	

	//@Pattern
	//Custom Validation

}
