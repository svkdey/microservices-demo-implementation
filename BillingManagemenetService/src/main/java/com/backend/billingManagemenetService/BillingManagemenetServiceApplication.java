package com.backend.billingManagemenetService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BillingManagemenetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingManagemenetServiceApplication.class, args);
	}

}
