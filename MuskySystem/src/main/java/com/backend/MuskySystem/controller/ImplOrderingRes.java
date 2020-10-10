package com.backend.MuskySystem.controller;

import javax.ws.rs.core.Response;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backend.MuskySystem.models.Product;


@RequestMapping("/api")
@RefreshScope
public interface ImplOrderingRes {
	
	@RequestMapping(value = "/customer/{id}/order", method = RequestMethod.POST)
	public Response doOrder(@PathVariable String id,@RequestBody Product product) throws Exception;
}
