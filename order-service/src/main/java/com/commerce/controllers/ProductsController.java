package com.commerce.controllers;

import com.commerce.dtos.ProductDto;
import com.commerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductsController
{
	private ProductService productService;

	public ProductsController(ProductService productService)
	{
		super();
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getProducts()
	{
		return null;
	}

	@GetMapping("/{productCode}")
	public ResponseEntity<ProductDto> getProductDetails(@PathVariable String productCode)
	{
		ProductDto productDto = productService.getProductDetails(Long.parseLong(productCode));
		return ResponseEntity.ok(productDto);
	}

}
