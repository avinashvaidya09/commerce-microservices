package com.commerce.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "prices")
public class PriceModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id")
	private Long priceId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductModel product;

	@Column(name = "price", nullable = false)
	private Double price;

	@Column(name = "currency")
	private String currency;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();

	public Long getPriceId()
	{
		return priceId;
	}

	public void setPriceId(Long priceId)
	{
		this.priceId = priceId;
	}

	public ProductModel getProduct()
	{
		return product;
	}

	public void setProduct(ProductModel product)
	{
		this.product = product;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt)
	{
		this.updatedAt = updatedAt;
	}
}
