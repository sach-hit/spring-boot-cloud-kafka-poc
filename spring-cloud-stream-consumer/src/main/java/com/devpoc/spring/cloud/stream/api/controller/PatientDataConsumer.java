package com.devpoc.spring.cloud.stream.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devpoc.spring.cloud.stream.api.domain.Patient;


@EnableBinding(Sink.class)
@RestController
@RequestMapping(value="/patients")
public class PatientDataConsumer {
	
	private Logger logger = LoggerFactory.getLogger(PatientDataConsumer.class);

    @StreamListener("input")
    public void consumeMessage(Patient patient) {
        logger.info("Consume payload : " + patient);
		
    }

}
