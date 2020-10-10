package com.backend.MuskySystem.controller;

import javax.ws.rs.core.Response;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/api")
@RefreshScope
public interface ImplGetOrderDetailsImpl {
	
	@RequestMapping(value = "/customer/{id}/order", method = RequestMethod.GET)
	public Response getOrders(@PathVariable String id) throws Exception;
}
