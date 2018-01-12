package com.rest.exercise.DTO;

public class ApplicationDTO{
	private String applicationName;
	private String applicationId;
	
	public ApplicationDTO(){
		
	}
	
	public ApplicationDTO(String name, String id)
	{
		this.applicationName = name;
		this.applicationId = id;
	}
	
	public static ApplicationDTO createApplication(String name, String id){
		return new ApplicationDTO(name, id);
	}
	
	public String getApplicationName()
	{
		return applicationName;
	}
	public void setName(String name)
	{
		this.applicationName = name;
	}
	public String getApplicationId()
	{
		return applicationId;
	}
	public void setId(String id)
	{
		this.applicationId = id;
	}
	
}
