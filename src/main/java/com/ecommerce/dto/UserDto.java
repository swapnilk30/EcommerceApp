package com.ecommerce.dto;

import java.util.List;

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

	private String name;

	private String email;

	private String password;
	
	private String imageName;
	

}
