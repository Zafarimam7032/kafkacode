package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MessageController {
	@Autowired
	private KafkaTemplate kafkaTemplate;
	
	private String Topic="mytopic";
	
	@GetMapping(path = "/kafka/{message}")
	public String messagedisplay(@PathVariable("message") String message) {
		kafkaTemplate.send(Topic, message);
		return "Sucessfully send message:" + message;
	}

}
