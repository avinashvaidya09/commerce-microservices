package com.commerce.mappers;

import com.commerce.dtos.PriceDto;
import com.commerce.models.PriceModel;
import org.springframework.stereotype.Component;


@Component
public class PriceReverseMapper
{

	public void map(PriceModel source, PriceDto target)
	{
		target.setPrice(source.getPrice());
		target.setCurrency(source.getCurrency());
	}
}
