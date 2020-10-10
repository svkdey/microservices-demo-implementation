package com.backend.MuskySystem.controller;

import javax.ws.rs.core.Response;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RefreshScope
public class Alive {
	@RequestMapping(value = "/alive", method = RequestMethod.GET)
	public Response alive() {
		return Response.ok("UP").build();
	}
}


