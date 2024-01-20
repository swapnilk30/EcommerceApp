package com.ecommerce.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ecommerce.controller.impl.UserControllerImpl;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final Logger log=LoggerFactory.getLogger(ResourceNotFoundException.class);

	public ResourceNotFoundException() {
		super("Resouce not found Exception!!");
	}

	public ResourceNotFoundException(String messege) {
		super(messege);
		log.error("Resouce not found Exception!!");
	}

}
