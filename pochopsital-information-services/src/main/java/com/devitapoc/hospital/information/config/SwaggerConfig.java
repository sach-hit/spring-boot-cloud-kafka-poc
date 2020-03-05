package com.devitapoc.hospital.information.config;

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
        return new Docket(DocumentationType.SWAGGER_2).groupName("Hospital Information").select()
                .apis(RequestHandlerSelectors.basePackage("com.devitapoc.hospital.information"))
                .paths(any()).build().apiInfo(new ApiInfo("Hospital Information",
                        "A set of services to provide data access to hospitals", "1.0.0", null,
                        new Contact("sachin", "https://", null),null, null));
    }

}