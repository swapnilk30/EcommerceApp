package com.ecommerce.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order
{
	@Id
	private String orderId;
	
	//PENDING , DISPATCHED, DELIVERED
	private String orderStatus;
	
	//NOTPAID , PAID
	private String paymentStatus;
	
	private double orderAmount;
	
	private String billingAddress;
	
	private String billingPhone;
	
	private String billingName;
	
	private Date orderedDate;
	
	private Date deliveredDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<>();
	
	
	
	
	
	
}
