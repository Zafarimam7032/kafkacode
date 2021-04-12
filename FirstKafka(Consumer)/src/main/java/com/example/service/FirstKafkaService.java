package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FirstKafkaService {
	@KafkaListener(topics = "mytopic",groupId = "group_id")
	public void consume(String message)
	{
		System.out.println(message);
	}

}
