package com.backend.MuskySystem.serviceImpl;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.backend.MuskySystem.controller.ImplOrderingRes;
import com.backend.MuskySystem.dto.Customer;
import com.backend.MuskySystem.dto.TransactionDetails;
import com.backend.MuskySystem.models.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.*;
import brave.Tracing;

@RestController
public class ImplOrderingResImpl implements ImplOrderingRes {
	@Autowired
	private Tracing tracer;

	@Autowired
	private RestTemplate connector;

	@Value("${customerSystem}")
	private String customerSystem;

	@Value("${billingSystem}")
	private String billingSystem;

	@Override
	@HystrixCommand(fallbackMethod = "doOrderErrorMethod", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000"), })
	public Response doOrder(String id, Product product) throws Exception {

		ResponseEntity<Customer> customerDetails = null;
		try {
			customerDetails = connector.getForEntity(customerSystem + "customer-api/customer/" + id, Customer.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " #  " + tracer.currentTraceContext().get().parentIdString(),
					e.getCause());

		}
		ResponseEntity<TransactionDetails> productRecipt = null;

		TransactionDetails transact = new TransactionDetails();
		transact.setBillingAccountId(customerDetails.getBody().getBillingAccount());
		transact.setPrice(product.getAmount());
		transact.setProductId(product.getProduct());
		System.out.println(product);
		try {
			productRecipt = connector.postForEntity(billingSystem + "/billing-api/pay/", transact,
					TransactionDetails.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " #  " + tracer.currentTraceContext().get().parentIdString(),
					e.getCause());

		}

		return Response.ok(productRecipt.getBody())
				.header("traceId", tracer.currentTraceContext().get().parentIdString()).build();

	}

	public Response doOrderErrorMethod(String id, Product product) {
		return Response.serverError().status(HttpStatus.SC_REQUEST_TIMEOUT).build();
	}

}
