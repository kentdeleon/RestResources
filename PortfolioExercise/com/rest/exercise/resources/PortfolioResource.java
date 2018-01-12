package com.rest.exercise.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.exercise.DTO.PortfolioDTO;
import com.rest.exercise.Service.PortfolioService;

@Path("/portfolios")
public class PortfolioResource
{
	PortfolioService portfolioService = new PortfolioService();
	CategoryResource categoryResource = new CategoryResource();
		
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPortfolios(){
		List<PortfolioDTO> portfolios = portfolioService.getAllPortfolios();
		
		return Response.ok(portfolios).build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{portfolioName}")
	public Response getPortfolio(@PathParam("portfolioName") String portfolioName){
		PortfolioDTO portfolio = portfolioService.getPortofolio(portfolioName);
		return Response.ok(portfolio).build();
	}
	

	@Path("/{portfolioName}/categories")
	public CategoryResource getCategories(){
		return new CategoryResource();
	}
}
