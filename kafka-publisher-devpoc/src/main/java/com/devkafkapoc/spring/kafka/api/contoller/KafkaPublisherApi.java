package com.devkafkapoc.spring.kafka.api.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devkafkapoc.spring.kafka.api.domain.Patient;

import io.swagger.annotations.ApiOperation;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class KafkaPublisherApi {

    @Autowired
    private KafkaTemplate<String, Object> template;
    
    @Value("${app.topic.name}")
    private String topic;
   
    @GetMapping("/publish/{name}")
    @ApiOperation(value="publish patient to kafka topic", notes="publish patient to kafka topic devpat", nickname = "publishpatientdata")
    public String publishMessage(@PathVariable String name) {
        template.send(topic, "Hi " + name + " Welcome to kafka poc");
        return "Data published";
    }

    @GetMapping("/publishJson")
    @ApiOperation(value="publish patient to kafka", notes="publish patient to kafka topic devpat", nickname = "publishpatientdata")
    public String publishMessage() {
        Patient patient = new Patient(2532, "Patient88", new String[] { "Bangalore", "BTM", "house 90" });
        template.send(topic, patient);
        return "Json Data published";
    }
}
