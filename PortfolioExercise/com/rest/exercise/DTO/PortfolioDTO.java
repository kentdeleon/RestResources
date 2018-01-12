package com.rest.exercise.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//@XmlRootElement
public class PortfolioDTO{
	private String portfolioName;
	private List<CategoryDTO> categories = new ArrayList<>();
	
	
    public PortfolioDTO(){
    	
    }
    public PortfolioDTO(String name){
    	this.portfolioName = name;
    }
	public PortfolioDTO(String name, List<CategoryDTO> categories)
	{
		this.portfolioName = name;
		this.categories.addAll(categories);
		
	}
	
	public static PortfolioDTO createPortfolio(String name){
		return new PortfolioDTO(name);
	}
	
	public void addCategory(CategoryDTO newCategory){
		categories.add(newCategory);
	}
	public String getPortfolioName()
	{
		return portfolioName;
	}
	public void setName(String name)
	{
		this.portfolioName = name;
	}
//	@XmlTransient
	public List<CategoryDTO> getCategories()
	{
		return categories;
	}
	public void setCategories(List<CategoryDTO> categories)
	{
		this.categories = categories;
	}
	
	
}
