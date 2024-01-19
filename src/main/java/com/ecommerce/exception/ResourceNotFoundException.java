package com.ecommerce.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resouce not found Exceptio !!");
	}
	public ResourceNotFoundException(String messege) {
		super(messege);
	}
	
}
