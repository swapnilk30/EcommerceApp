package com.ecommerce.exception;

public class BadApiRequestException extends RuntimeException {

	
	
	public BadApiRequestException() {
		super("Bad request !!");
	}
   public BadApiRequestException(String messege) {
		super(messege);
	}
}
