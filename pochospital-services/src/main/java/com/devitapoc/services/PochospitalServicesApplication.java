package com.devitapoc.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PochospitalServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PochospitalServicesApplication.class, args);
	}

}
