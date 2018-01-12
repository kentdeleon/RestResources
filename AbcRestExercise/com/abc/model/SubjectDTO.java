package com.abc.model;

public class SubjectDTO
{
	private String name;
	private String subjectCode;
	private String description;
	private int numberOfUnits;
	private String status;
	
	public SubjectDTO(){
		
	}

	public SubjectDTO(String name, String subjectCode, String description,
			int numberOfUnits, String status)
	{
		this.name = name;
		this.subjectCode = subjectCode;
		this.description = description;
		this.numberOfUnits = numberOfUnits;
		this.status = status;
	}

	public static SubjectDTO createSubject(String name, String subjectCode, String description,
			int numberOfUnits, String status){
		return new SubjectDTO(name, subjectCode, description, numberOfUnits, status);
	}
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSubjectCode()
	{
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getNumberOfUnits()
	{
		return numberOfUnits;
	}

	public void setNumberOfUnits(int numberOfUnits)
	{
		this.numberOfUnits = numberOfUnits;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
	
	
	
}
