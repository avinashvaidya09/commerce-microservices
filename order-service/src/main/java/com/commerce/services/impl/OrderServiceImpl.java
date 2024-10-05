package com.commerce.services.impl;

import com.commerce.dtos.OrderDto;
import com.commerce.dtos.OrderItemDto;
import com.commerce.events.OrderNotificationEvent;
import com.commerce.kafka.OrderProducer;
import com.commerce.mappers.OrderForwardMapper;
import com.commerce.mappers.OrderItemForwardMapper;
import com.commerce.mappers.OrderItemReverseMapper;
import com.commerce.mappers.OrderReverseMapper;
import com.commerce.models.OrderItemModel;
import com.commerce.models.OrderModel;
import com.commerce.models.UserModel;
import com.commerce.repository.OrderItemRepository;
import com.commerce.repository.OrderRepository;
import com.commerce.repository.UserRepository;
import com.commerce.services.OrderService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService
{

	private OrderRepository orderRepository;

	private OrderForwardMapper orderForwardMapper;

	private OrderReverseMapper orderReverseMapper;

	private OrderItemRepository orderItemRepository;

	private OrderItemForwardMapper orderItemForwardMapper;

	private OrderItemReverseMapper orderItemReverseMapper;

	private OrderProducer orderProducer;

	private UserRepository userRepository;

	public OrderServiceImpl(OrderRepository orderRepository, OrderForwardMapper orderForwardMapper,
			OrderReverseMapper orderReverseMapper, OrderItemRepository orderItemRepository,
			OrderItemForwardMapper orderItemForwardMapper, OrderItemReverseMapper orderItemReverseMapper,
			OrderProducer orderProducer, UserRepository userRepository)
	{
		super();
		this.orderRepository = orderRepository;
		this.orderForwardMapper = orderForwardMapper;
		this.orderReverseMapper = orderReverseMapper;
		this.orderItemRepository = orderItemRepository;
		this.orderItemForwardMapper = orderItemForwardMapper;
		this.orderItemReverseMapper = orderItemReverseMapper;
		this.orderProducer = orderProducer;
		this.userRepository = userRepository;
	}

	@Override
	public OrderDto createOrder(OrderDto order)
	{
		OrderModel orderModel = new OrderModel();
		this.orderForwardMapper.map(order, orderModel);
		orderRepository.saveAndFlush(orderModel);
		List<OrderItemModel> itemModels = new ArrayList<>(NumberUtils.INTEGER_ZERO);
		if (order.getItems() != null)
		{

			for (OrderItemDto itemSource : order.getItems())
			{
				OrderItemModel orderItemModel = new OrderItemModel();
				this.orderItemForwardMapper.map(itemSource, orderItemModel);
				orderItemModel.setOrder(orderModel);
				itemModels.add(orderItemModel);
			}
			orderItemRepository.saveAllAndFlush(itemModels);
		}
		orderReverseMapper.map(orderModel, order);

		List<OrderItemDto> orderItemDtos = new ArrayList<>(NumberUtils.INTEGER_ZERO);
		for (OrderItemModel itemModel : itemModels)
		{
			OrderItemDto itemDto = new OrderItemDto();
			orderItemReverseMapper.map(itemModel, itemDto);
			orderItemDtos.add(itemDto);
		}
		order.setItems(orderItemDtos);

		this.sendOrderNotificationsendOrderEvent(order);

		return order;
	}

	private void sendOrderNotificationsendOrderEvent(OrderDto order)
	{
		OrderNotificationEvent orderNotificationEvent = populateOrderNotificationEvent(order);
		this.orderProducer.sendMessage(orderNotificationEvent);

	}

	private OrderNotificationEvent populateOrderNotificationEvent(OrderDto order)
	{
		OrderNotificationEvent orderNotificationEvent = new OrderNotificationEvent();
		orderNotificationEvent.setOrderId(String.valueOf(order.getOrderId()));
		orderNotificationEvent.setStatus(order.getStatus());
		UserModel user = this.userRepository.findById(order.getCustomerId()).get();
		orderNotificationEvent.setCustomerEmailId(user.getEmail());
		double totalSum = order.getItems().stream().mapToDouble(OrderItemDto::getTotalPrice).sum();
		orderNotificationEvent.setTotalPrice(String.valueOf(totalSum));
		orderNotificationEvent.setMessage("Order created successfully!");
		return orderNotificationEvent;
	}
}
