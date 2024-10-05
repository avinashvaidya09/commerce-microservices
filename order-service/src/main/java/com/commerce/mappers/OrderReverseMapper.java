package com.commerce.mappers;

import com.commerce.dtos.OrderDto;
import com.commerce.models.OrderModel;
import org.springframework.stereotype.Component;


@Component
public class OrderReverseMapper
{
	public void map(OrderModel source, OrderDto target)
	{
		target.setOrderId(source.getOrderId());
		target.setAddressId(source.getAddress().getAddressId());
		target.setCustomerId(source.getCustomer().getUserId());
		target.setOrderDate(source.getOrderDate());
		target.setStatus(source.getStatus());
	}
}
