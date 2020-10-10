package com.backend.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementSystemApplication.class, args);
	}

}
