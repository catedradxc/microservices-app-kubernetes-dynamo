package com.ewolff.microservice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@ComponentScan
@EnableAutoConfiguration
@Component
public class OrderApp {

	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}

}
