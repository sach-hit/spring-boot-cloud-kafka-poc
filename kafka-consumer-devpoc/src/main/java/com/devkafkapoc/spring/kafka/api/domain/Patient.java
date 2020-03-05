package com.devkafkapoc.spring.kafka.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	private int id;
	private String name;
	private int age;
	private String address;
}
