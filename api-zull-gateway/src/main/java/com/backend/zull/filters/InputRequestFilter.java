package com.backend.zull.filters;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.zull.filters.models.LogginDeatils;
import com.backend.zull.filters.repoImpl.LoggingDB;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import brave.Tracing;

public class InputRequestFilter extends ZuulFilter {
	private static Logger logger = (Logger) LoggerFactory.getLogger(InputRequestFilter.class);
	@Autowired
	private Tracing tracer;
	@Autowired
	private LoggingDB db;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		LogginDeatils details = new LogginDeatils();
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest req = context.getRequest();

		details.setMethod(req.getMethod());
		details.setAPIname(req.getRequestURI());
		if ("POST".equalsIgnoreCase(req.getMethod()) || "PUT".equalsIgnoreCase(req.getMethod())) {
			try {
				String test = CharStreams.toString(req.getReader());
				details.setPayload(test);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		details.setTransactionID(tracer.currentTraceContext().get().localRootIdString());
		db.save(details);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {

		return 1;
	}

}
