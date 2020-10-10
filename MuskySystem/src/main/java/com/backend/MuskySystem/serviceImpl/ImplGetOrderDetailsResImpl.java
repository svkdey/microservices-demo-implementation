package com.backend.MuskySystem.serviceImpl;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.backend.MuskySystem.controller.ImplGetOrderDetailsImpl;
import com.backend.MuskySystem.dto.Customer;
import com.backend.MuskySystem.dto.ImplGetCustomerResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import brave.Tracing;
@RestController
public class ImplGetOrderDetailsResImpl implements ImplGetOrderDetailsImpl{
	@Autowired
	private Tracing tracer;

	@Autowired
	private RestTemplate connector;
	
	@Value("${customerSystem}")
	private String customerSystem;
	
	@Value("${billingSystem}")
	private String billingSystem;
	
	@Override
	@HystrixCommand(fallbackMethod = "getOrdersErrorMethod", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000"), })
	public Response getOrders(String id) throws Exception {
		System.out.println(id);
		ResponseEntity<Customer> customerDetails = null;
		try {
			customerDetails = connector.getForEntity(customerSystem+"customer-api/customer/" + id,
					Customer.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " #  " + tracer.currentTraceContext().get().parentIdString(),
					e.getCause());

		}
		System.out.println(customerDetails.getBody());
		ResponseEntity<ImplGetCustomerResponse> productList = null;

		try {
			productList = connector.getForEntity(billingSystem+"/billing-api/bill/"+customerDetails.getBody().getBillingAccount(), ImplGetCustomerResponse.class);
		} catch (Exception e) {
			throw new Exception(e.getMessage() + " #  " + tracer.currentTraceContext().get().parentIdString(),
					e.getCause());

		}
		System.out.println(productList.getBody());
		return Response.ok(productList.getBody())
				.header("traceId", tracer.currentTraceContext().get().parentIdString()).build();

	}
	
	public Response getOrdersErrorMethod(String id)  {
		return Response.serverError().status(HttpStatus.SC_REQUEST_TIMEOUT).build();
	}

	

}
