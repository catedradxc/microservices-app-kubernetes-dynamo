package com.ewolff.microservice.customer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@EnableAutoConfiguration
@Component
public class CustomerApp {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApp.class, args);
	}

}
