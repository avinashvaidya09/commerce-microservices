package com.commerce.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users", schema = "commerce")
public class UserModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderModel> orders;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Date getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt(Date createdAt)
	{
		this.createdAt = createdAt;
	}

	public List<OrderModel> getOrders()
	{
		return orders;
	}

	public void setOrders(List<OrderModel> orders)
	{
		this.orders = orders;
	}
}
