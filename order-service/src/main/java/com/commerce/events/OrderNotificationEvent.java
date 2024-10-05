package com.commerce.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderNotificationEvent implements Serializable
{
	private String message;

	private String status;

	private String orderId;

	private String totalPrice;

	private String customerEmailId;
}
