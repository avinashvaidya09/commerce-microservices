package com.commerce.dtos;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto
{
	private Long orderId;
	private Date orderDate;
	private Long customerId;
	private Double totalAmount;
	private String status;
	private Long addressId;
	private List<OrderItemDto> items;
}
