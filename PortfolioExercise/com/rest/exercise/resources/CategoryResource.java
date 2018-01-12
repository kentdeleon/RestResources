package com.rest.exercise.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.exercise.DTO.CategoryDTO;
import com.rest.exercise.Service.CategoryService;

@Path("/")
public class CategoryResource{
	
	CategoryService categoryService = new CategoryService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
	public Response getAllCategories(@PathParam("portfolioName") String portfolioName){
		List<CategoryDTO> categories = categoryService.getAllCategories(portfolioName);
		
		return Response.ok(categories).build();
//		return "Category URI: " + portfolioName;
	}
	
	@GET
	@Path("/{categoryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllApplication(@PathParam("portfolioName") String portfolioName, @PathParam("categoryName") String categoryName){
		CategoryDTO category = categoryService.getAllCategories(portfolioName, categoryName);
		return Response.ok(category).build();
		
		
	}
	
	@Path("/{categoryName}/applications")
	@Produces(MediaType.APPLICATION_JSON)
	public ApplicationResource getApplicationResource(){
		return new ApplicationResource();
	}

}
