package com.commerce.mappers;

import com.commerce.dtos.OrderDto;
import com.commerce.dtos.OrderItemDto;
import com.commerce.enums.OrderStatus;
import com.commerce.models.AddressModel;
import com.commerce.models.OrderItemModel;
import com.commerce.models.OrderModel;
import com.commerce.models.UserModel;
import com.commerce.repository.AddressRepository;
import com.commerce.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Component
public class OrderForwardMapper
{
	private OrderItemForwardMapper orderItemForwardMapper;

	private AddressRepository addressRepository;

	private UserRepository userRepository;

	public OrderForwardMapper(OrderItemForwardMapper orderItemForwardMapper, AddressRepository addressRepository,
			UserRepository userRepository)
	{
		super();
		this.orderItemForwardMapper = orderItemForwardMapper;
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	public void map(OrderDto source, OrderModel target)
	{
		AddressModel addressModel = this.addressRepository.findById(source.getAddressId()).get();
		UserModel userModel = this.userRepository.findById(source.getCustomerId()).get();
		target.setAddress(addressModel);
		target.setCustomer(userModel);
		target.setStatus(source.getStatus() != null ? OrderStatus.valueOf(source.getStatus().toUpperCase(Locale.ROOT)).toString() : OrderStatus.PENDING.name());
		double totalSum = source.getItems().stream().mapToDouble(OrderItemDto::getTotalPrice).sum();
		target.setTotalAmount(BigDecimal.valueOf(totalSum));
	}
}
