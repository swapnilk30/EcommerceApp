package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderRequest {
	
	//@NotBlank(message = "User id is Required !!")
	private String userId;
	
	//@NotBlank(message = "Cart id is Required !!")
	private String cartId;
	
	private String orderStatus = "PENDING";
	
	private String paymentStatus ="NOTPAID" ;
	
	
	//@NotBlank(message = "Address is Required !!")
	private String billingAddress;
	
	
	//@NotBlank(message = "phone is Required !!")
	private String billingPhone;
	
	//@NotBlank(message = "Name is Required !!")
	private String billingName;
	
}
