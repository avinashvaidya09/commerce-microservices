package com.commerce.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders", schema = "commerce")
public class OrderModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate = new Date();

	@Column(name = "total_amount")
	private BigDecimal totalAmount;

	@Column(name = "status", nullable = false, columnDefinition = "DEFAULT 'ACTIVE'")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", nullable = false)
	private AddressModel address;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderItemModel> orderItems;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private UserModel customer;

	public Long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	public UserModel getCustomer()
	{
		return customer;
	}

	public void setCustomer(UserModel customer)
	{
		this.customer = customer;
	}

	public BigDecimal getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public AddressModel getAddress()
	{
		return address;
	}

	public void setAddress(AddressModel address)
	{
		this.address = address;
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

	public List<OrderItemModel> getOrderItems()
	{
		return orderItems;
	}

	public void setOrderItems(List<OrderItemModel> orderItems)
	{
		this.orderItems = orderItems;
	}
}
