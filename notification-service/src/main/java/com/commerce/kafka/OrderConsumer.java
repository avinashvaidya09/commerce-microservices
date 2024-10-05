package com.commerce.kafka;

import com.commerce.events.OrderNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderConsumer
{
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderNotificationEvent orderNotificationEvent, Acknowledgment acknowledgment)
	{
		log.info("Order notification event received: {}", orderNotificationEvent.toString());

		acknowledgment.acknowledge();
	}
}
