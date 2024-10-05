package com.commerce.services;

import com.commerce.dtos.ProductDto;


public interface ProductService
{
	ProductDto getProductDetails(Long productCode);
}
