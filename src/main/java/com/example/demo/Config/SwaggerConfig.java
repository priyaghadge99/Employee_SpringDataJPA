package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class SwaggerConfig {

	
	@Bean
	public OpenAPI CustomSwaggerConfig() {
		return new OpenAPI().info(new Info()
				.title("Employee")
				.description("Employee Details")
				.version("v1")
				.contact(new Contact() 
						.email("priyghadge59@gmail.com")
						.name("Priya")));
		
	}
}
