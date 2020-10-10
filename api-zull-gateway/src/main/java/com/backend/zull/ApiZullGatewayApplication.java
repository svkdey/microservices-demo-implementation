package com.backend.zull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.backend.zull.filters.InputRequestFilter;
import com.backend.zull.filters.OutputResponseFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class ApiZullGatewayApplication {
	
	@Bean
	public InputRequestFilter getInComingReqFilter() {
		return new InputRequestFilter();
	}
	
	@Bean
	public OutputResponseFilter getOutResFilter() {
		return new OutputResponseFilter();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiZullGatewayApplication.class, args);
	}

}
