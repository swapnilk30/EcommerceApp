package com.ecommerce.dto;

import org.springframework.http.HttpStatus;

public class ApiResponseMessege {
	
	private  String messege;
	private HttpStatus Status;
	
	public ApiResponseMessege() {
	}
	
	public ApiResponseMessege(String messege, HttpStatus status) {
		super();
		this.messege = messege;
		Status = status;
	}

	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public HttpStatus getStatus() {
		return Status;
	}
	public void setStatus(HttpStatus status) {
		Status = status;
	}
	

}
