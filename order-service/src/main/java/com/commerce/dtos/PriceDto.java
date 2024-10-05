package com.commerce.dtos;

import lombok.Data;

import java.io.Serializable;


@Data
public class PriceDto implements Serializable
{
	private Double price;

	private String currency;
}
