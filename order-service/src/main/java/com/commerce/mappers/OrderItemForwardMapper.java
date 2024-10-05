package com.commerce.mappers;

import com.commerce.dtos.OrderItemDto;
import com.commerce.models.OrderItemModel;
import com.commerce.models.ProductModel;
import com.commerce.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderItemForwardMapper
{

	ProductRepository productRepository;

	public OrderItemForwardMapper(ProductRepository productRepository)
	{
		super();
		this.productRepository = productRepository;
	}

	public void map(OrderItemDto source, OrderItemModel target)
	{
		ProductModel productModel =this.productRepository.findById(source.getProductId()).get();
		target.setProduct(productModel);
		target.setQuantity(source.getQuantity());
		target.setTotalPrice(BigDecimal.valueOf(source.getTotalPrice()));
	}
}
