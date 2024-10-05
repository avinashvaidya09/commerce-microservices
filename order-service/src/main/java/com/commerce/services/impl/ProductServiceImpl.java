package com.commerce.services.impl;

import com.commerce.dtos.ProductDto;
import com.commerce.exceptions.ResourceNotFoundException;
import com.commerce.mappers.ProductReverseMapper;
import com.commerce.models.ProductModel;
import com.commerce.repository.ProductRepository;
import com.commerce.services.ProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements ProductService
{

	private ProductRepository productRepository;

	private ProductReverseMapper productReverseMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductReverseMapper productReverseMapper)
	{
		this.productRepository = productRepository;
		this.productReverseMapper = productReverseMapper;
	}

	@Override
	public ProductDto getProductDetails(Long productCode)
	{
		ProductModel productModel = productRepository.findById(productCode)
				.orElseThrow(() -> new ResourceNotFoundException("Products", "productCode", productCode.toString()));
		ProductDto productDto = new ProductDto();
		this.productReverseMapper.map(productModel, productDto);
		return productDto;
	}
}
