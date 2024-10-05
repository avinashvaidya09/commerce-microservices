package com.commerce.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ProductDto implements Serializable
{
	private Long productCode;

	private String name;

	private String description;

	private String category;

	private String brand;

	private String sku;

	private List<PriceDto> prices;

}
