package com.rest.exercise.DTO;

import java.util.List;
import java.util.ArrayList;

public class CategoryDTO
{
	private String categoryName;
	private List<ApplicationDTO> applications = new ArrayList<>();
	
	public CategoryDTO(){
		
	}
	
	
	public CategoryDTO(String name){
		this.categoryName = name;
	}
	public CategoryDTO(String name, List<ApplicationDTO> applications){
		this.categoryName = name;
		this.applications.addAll(applications);
		
		
	}
	
	public static CategoryDTO createCategory(String name){
		return new CategoryDTO(name);
	}
	
	public void addApplication(ApplicationDTO newApplication){
		applications.add(newApplication);
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	public void setName(String name)
	{
		this.categoryName = name;
	}
	public List<ApplicationDTO> getApplications()
	{
		return applications;
	}
	public void setApplications(List<ApplicationDTO> applications)
	{
		this.applications = applications;
	}
	
	

}
