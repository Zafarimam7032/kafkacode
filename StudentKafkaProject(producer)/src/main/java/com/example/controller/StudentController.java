package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Vo.StudentVo;

@RestController
public class StudentController {
	
	@Autowired
	private KafkaTemplate<String, StudentVo> kafkaTemplate;
	private String TOPIC ="mytopic";
	@GetMapping(path = "/kafka/display")
	public StudentVo displayStudent()
	{
		StudentVo studentVo = new StudentVo(1,"Zafar","Jntuh","New delhi");
		kafkaTemplate.send(TOPIC,studentVo);
		return studentVo;
	}
	
	@PostMapping(path = "/insert/student")
	public StudentVo addStudent(@RequestBody StudentVo studentVo)
	{
		kafkaTemplate.send(TOPIC,studentVo);
	return studentVo;	
	}

}
