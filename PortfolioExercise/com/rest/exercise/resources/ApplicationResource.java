package com.rest.exercise.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.exercise.DTO.ApplicationDTO;
import com.rest.exercise.Service.ApplicationService;

@Path("/")
public class ApplicationResource
{
	private ApplicationService applicationService = new ApplicationService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllApplications(@PathParam("categoryName") String categoryName, @PathParam("portfolioName") String portfolioName){
		List<ApplicationDTO> applications = applicationService.getAllApplications(portfolioName, categoryName);
		return Response.ok(applications).build();
	}

}
