package com.backend.zull.filters;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.zull.filters.models.LogginDeatils;
import com.backend.zull.filters.repoImpl.LoggingDB;
import com.google.common.io.CharStreams;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import brave.Tracing;
import ch.qos.logback.classic.Logger;

public class OutputResponseFilter extends ZuulFilter {
	private static Logger logger = (Logger) LoggerFactory.getLogger(OutputResponseFilter.class);
	@Autowired
	private Tracing tracer;
	@Override
	public boolean shouldFilter() { 
		return true;
	}
	@Autowired
	private LoggingDB db;
	@Override
	public Object run() throws ZuulException {
		LogginDeatils details = new LogginDeatils();
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest req = context.getRequest();
		details.setMethod(req.getMethod());
		details.setAPIname(req.getRequestURI());
		try (final InputStream responseDataStream = context.getResponseDataStream()) {

			if (responseDataStream == null) {
				logger.info("BODY: {}", "");
				
			}else {

				String responseData = CharStreams.toString(new InputStreamReader(responseDataStream, "UTF-8"));
				logger.info("BODY: {}", responseData);
				details.setPayload(responseData);
				context.setResponseBody(responseData);
				details.setTransactionID(tracer.currentTraceContext().get().localRootIdString());
				db.save(details);
			}
		} catch (Exception e) {
			details.setPayload(e.getMessage());
			details.setTransactionID(tracer.currentTraceContext().get().localRootIdString());
			
			db.save(details);
			throw new ZuulException(e.getCause(), 500, e.getMessage());
		}

		return null;

	}

	@Override
	public String filterType() {
		
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
