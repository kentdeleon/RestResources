package com.kent.advanceRest;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class MyResource {

	@GET
	//@Produces(MediaType.TEXT_PLAIN) - for Advanced JAX-RS 11 - Implementing a MessageBodyWriter
	@Produces(value = {MediaType.TEXT_PLAIN,"text/shortdate"})
	public Date testMethod() {
		return Calendar.getInstance().getTime();
	}
}
