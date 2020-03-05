package com.devkafkapoc.spring.kafka.api.config;

import static springfox.documentation.builders.PathSelectors.any;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("Patients Data Cosumer").select()
                .apis(RequestHandlerSelectors.basePackage("com.devkafkapoc.spring.kafka.api"))
                .paths(any()).build().apiInfo(new ApiInfo("Patient Services",
                        "A set of services to consumes patient data from kafka topic", "1.0.0", null,
                        new Contact("sachin", "https://", null),null, null));
    }

}