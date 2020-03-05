package com.devkafkapoc.spring.kafka.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devkafkapoc.spring.kafka.api.domain.Patient;

import io.swagger.annotations.ApiOperation;

@RestController
public class kafkaConsumerController {
	
	List<String> messages = new ArrayList<>();

	Patient patientFromTopic =null;

	@GetMapping("/consumeStringMessage")
	 @ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic patient-stream", nickname = "publishpatientdata")
	public List<String> consumeMsg() {
		return messages;
	}

	@GetMapping("/consumeJsonMessage")
	 @ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic patient-stream", nickname = "publishpatientdata")
	public Patient consumeJsonMessage() {
		return patientFromTopic;
	}

	@KafkaListener(groupId = "devpat", topics = "devkafkapoc", containerFactory = "kafkaListenerContainerFactory")
	 @ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic patient-stream", nickname = "publishpatientdata")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
	}

	@KafkaListener(groupId = "devpat2", topics = "devkafkapoc", containerFactory = "userKafkaListenerContainerFactory")
	@ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic patient-stream", nickname = "publishpatientdata")
	public Patient getJsonMsgFromTopic(Patient patient) {
		patientFromTopic= patient;
		return patientFromTopic;
	}

}
