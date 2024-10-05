package com.commerce.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "addresses", schema = "commerce")
public class AddressModel
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long addressId;

	@Column(name = "street", nullable = false)
	private String street;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "zip_code", nullable = false)
	private String zipCode;

	@Column(name = "country", nullable = false)
	private String country;

	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderModel> orders;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt = new Date();

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt = new Date();

	public Long getAddressId()
	{
		return addressId;
	}

	public void setAddressId(Long addressId)
	{
		this.addressId = addressId;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
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
