package com.commerce.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "order_items", schema = "commerce")
public class OrderItemModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private Long orderItemId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private OrderModel order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private ProductModel product;

	@Column(name = "quantity", nullable = false)
	private int quantity;

	@Column(name = "total_price", nullable = false)
	private BigDecimal totalPrice;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();

	public Long getOrderItemId()
	{
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId)
	{
		this.orderItemId = orderItemId;
	}

	public OrderModel getOrder()
	{
		return order;
	}

	public void setOrder(OrderModel order)
	{
		this.order = order;
	}

	public ProductModel getProduct()
	{
		return product;
	}

	public void setProduct(ProductModel product)
	{
		this.product = product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice)
	{
		this.totalPrice = totalPrice;
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
