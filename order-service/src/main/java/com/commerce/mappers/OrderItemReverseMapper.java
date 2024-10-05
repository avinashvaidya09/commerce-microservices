package com.commerce.mappers;

import com.commerce.dtos.OrderItemDto;
import com.commerce.models.OrderItemModel;
import com.commerce.repository.OrderItemRepository;
import org.springframework.stereotype.Component;


@Component
public class OrderItemReverseMapper
{
	private OrderItemRepository orderItemRepository;

	public OrderItemReverseMapper(OrderItemRepository orderItemRepository)
	{
		super();
		this.orderItemRepository = orderItemRepository;
	}

	public void map(OrderItemModel source, OrderItemDto target)
	{
		target.setOrderItemId(source.getOrderItemId());
		target.setQuantity(source.getQuantity());
		target.setProductId(source.getProduct().getProduct_id());
		target.setTotalPrice(source.getTotalPrice().doubleValue());
	}
}
