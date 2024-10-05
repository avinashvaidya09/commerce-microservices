package com.commerce.models;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "products")
public class ProductModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;

	private String name;

	private String description;

	private String category;

	private String brand;

	private String sku;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PriceModel> prices;

	public Long getProduct_id()
	{
		return product_id;
	}

	public void setProduct_id(Long product_id)
	{
		this.product_id = product_id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getSku()
	{
		return sku;
	}

	public void setSku(String sku)
	{
		this.sku = sku;
	}

	public List<PriceModel> getPrices()
	{
		return prices;
	}

	public void setPrices(List<PriceModel> prices)
	{
		this.prices = prices;
	}
}
