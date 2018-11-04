package com.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class EmployeeDtlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDtlsApplication.class, args);
	}
	
	@Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmployeeDtlsApplication.class);
    }
}
