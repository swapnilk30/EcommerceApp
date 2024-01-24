package com.ecommerce.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ecommerce.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

	private String cartId;

	private Date createdAt;

	private UserDto userDto;

	private List<CartItemDto> items = new ArrayList<>();

}
