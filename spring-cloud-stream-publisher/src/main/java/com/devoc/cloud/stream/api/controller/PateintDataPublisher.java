package com.devoc.cloud.stream.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devoc.cloud.stream.api.domain.Patient;

import io.swagger.annotations.ApiOperation;

@EnableBinding(Source.class)
@RestController
@RequestMapping(value="")
public class PateintDataPublisher {
	    
	    @Autowired
	    private MessageChannel output;

	    @PostMapping("/publish")
	    @ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic patient-stream", nickname = "publishpatientdata")
	    public Patient publishEvent(@RequestBody Patient patient) {
	        output.send(MessageBuilder.withPayload(patient).build());
	        return patient;
	    }

}
