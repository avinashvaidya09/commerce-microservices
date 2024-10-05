package com.commerce.mappers;

import com.commerce.dtos.PriceDto;
import com.commerce.dtos.ProductDto;
import com.commerce.models.PriceModel;
import com.commerce.models.ProductModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductReverseMapper
{

	PriceReverseMapper priceReverseMapper;

	public ProductReverseMapper(PriceReverseMapper priceReverseMapper)
	{
		super();
		this.priceReverseMapper = priceReverseMapper;
	}

	public void map(ProductModel source,  ProductDto target)
	{
		if (target == null) {
			target = new ProductDto();
		}
		target.setName(source.getName());
		target.setProductCode(source.getProduct_id());
		target.setBrand(source.getBrand());
		target.setCategory(source.getCategory());
		target.setDescription(source.getDescription());
		target.setSku(source.getSku());

		if (source.getPrices() != null) {

			List<PriceDto> prices = new ArrayList<>();
			for (PriceModel priceModel: source.getPrices())
			{
				PriceDto priceDto = new PriceDto();
				this.priceReverseMapper.map(priceModel, priceDto);
				prices.add(priceDto);
			}
			target.setPrices(prices);
		}

	}
}
