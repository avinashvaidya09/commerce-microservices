package com.commerce.controllers;

import com.commerce.dtos.OrderDto;
import com.commerce.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController
{
	private OrderService orderService;

	public OrdersController(OrderService orderService)
	{
		this.orderService = orderService;
	}

	@PostMapping("/create")
	public OrderDto createOrder(@RequestBody OrderDto orderDto)
	{
		return this.orderService.createOrder(orderDto);
	}
}
