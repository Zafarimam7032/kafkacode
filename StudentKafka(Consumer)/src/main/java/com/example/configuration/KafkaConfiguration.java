package com.example.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.Vo.StudentVo;

@Configuration
@EnableKafka
public class KafkaConfiguration {
	@Bean
	public ConsumerFactory<String, StudentVo> consumerFactory()
	{
		Map<String, Object> config=new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(StudentVo.class));
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,StudentVo> concurrentKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, StudentVo> concurrentKafkaListenerContainerFactory=new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
		return concurrentKafkaListenerContainerFactory;
	}
}
