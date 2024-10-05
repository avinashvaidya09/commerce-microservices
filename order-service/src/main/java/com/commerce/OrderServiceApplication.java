package com.commerce;

import com.commerce.controllers.ProductsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class OrderServiceApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
