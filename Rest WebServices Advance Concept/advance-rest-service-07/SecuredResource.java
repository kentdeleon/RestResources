package com.kent.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecuredResource {

	@GET
	@Path("messages")
	@Produces(MediaType.TEXT_PLAIN)
	public String securityMethod() {
		return "Successfully access the resource with the right authorization";
	}
}
