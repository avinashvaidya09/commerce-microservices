package com.commerce.dtos;

import lombok.Data;


@Data
public class OrderItemDto
{
	private Long orderItemId;
	private Long productId;
	private int quantity;
	private double totalPrice;
}
