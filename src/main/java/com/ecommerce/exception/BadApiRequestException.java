package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadApiRequestException extends RuntimeException {

	
	
	public BadApiRequestException() {
		super("Bad request !!");
	}
   public BadApiRequestException(String messege) {
		super(messege);
	}
}
