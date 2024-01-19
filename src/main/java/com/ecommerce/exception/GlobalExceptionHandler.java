package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.dto.ApiResponseMessege;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//HandleResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessege> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		ApiResponseMessege responseMessege=new ApiResponseMessege(ex.getMessage(),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseMessege,HttpStatus.NOT_FOUND);
	
	}
}
