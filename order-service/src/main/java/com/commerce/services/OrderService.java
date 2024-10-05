package com.commerce.services;

import com.commerce.dtos.OrderDto;


public interface OrderService
{
	OrderDto createOrder(OrderDto order);
}
