package com.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("Resouce not found Exception!!");
	}

	public ResourceNotFoundException(String messege) {
		super(messege);
	}

}
