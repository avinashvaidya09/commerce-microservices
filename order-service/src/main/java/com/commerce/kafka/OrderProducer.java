package com.commerce.kafka;

import com.commerce.events.OrderNotificationEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderProducer
{
	private NewTopic newTopic;

	private KafkaTemplate<String, OrderNotificationEvent> kafkaTemplate;

	public OrderProducer(NewTopic newTopic,
			KafkaTemplate<String, OrderNotificationEvent> kafkaTemplate)
	{
		this.newTopic = newTopic;
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(OrderNotificationEvent orderNotificationEvent)
	{
		//create message
		Message<OrderNotificationEvent> message = MessageBuilder.withPayload(orderNotificationEvent).setHeader(KafkaHeaders.TOPIC, newTopic.name())
				.build();
		log.info("Sending message to kafka topic: {}", this.newTopic.name());
		this.kafkaTemplate.send(message);

	}

}
