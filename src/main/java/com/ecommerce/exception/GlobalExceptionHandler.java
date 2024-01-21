package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.dto.ApiResponseMessege;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// HandleResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponseMessege> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ApiResponseMessege responseMessege = new ApiResponseMessege(ex.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(responseMessege, HttpStatus.NOT_FOUND);

	}
	
	//handle Bad API ReQUEST EXCEPTIOn
	@ExceptionHandler(BadApiRequestException.class)
	public ResponseEntity<ApiResponseMessege> handleBadApiRequestException(BadApiRequestException ex){
		ApiResponseMessege responseMessege = new ApiResponseMessege(ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(responseMessege,HttpStatus.BAD_REQUEST);
	}

}
