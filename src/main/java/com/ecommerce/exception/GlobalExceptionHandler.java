package com.ecommerce.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	// handle Bad API ReQUEST EXCEPTIOn
	@ExceptionHandler(BadApiRequestException.class)
	public ResponseEntity<ApiResponseMessege> handleBadApiRequestException(BadApiRequestException ex) {
		ApiResponseMessege responseMessege = new ApiResponseMessege(ex.getMessage(), HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(responseMessege, HttpStatus.BAD_REQUEST);
	}

	/*
	// MethodArgumentNotValidException
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {
		List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
		Map<String, Object> response = new HashMap<>();
		allErrors.stream().forEach(objectError -> {
			String message = objectError.getDefaultMessage();
			String field = ((FieldError) objectError).getField();
			response.put(field, message);
		});
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	*/

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
