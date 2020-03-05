package com.devitapoc.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PocpatientServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocpatientServicesApplication.class, args);
	}

}
