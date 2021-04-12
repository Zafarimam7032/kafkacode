package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Vo.StudentVo;

@Service
public class FirstKafkaService {
	@KafkaListener(topics = "mytopic",groupId = "group_id",containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consume(StudentVo studentVo)
	{
		System.out.println(studentVo);
	}

}
