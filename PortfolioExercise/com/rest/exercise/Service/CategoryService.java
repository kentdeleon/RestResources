package com.rest.exercise.Service;

import java.util.ArrayList;
import java.util.List;

import com.rest.exercise.DAO.ApplicationDAO;
import com.rest.exercise.DTO.CategoryDTO;
import com.rest.exercise.DTO.PortfolioDTO;

public class CategoryService
{
	private List<PortfolioDTO> portfolios = ApplicationDAO.getPorfolios();
	
	public CategoryService(){
		List<CategoryDTO> categories = new ArrayList<>();
		
		for(int i = 0 ; i < portfolios.size(); i++){
			categories.addAll(portfolios.get(i).getCategories());
		}
	}
	
	public List<CategoryDTO> getAllCategories(String portfolioName){
		List<CategoryDTO> categories = new ArrayList<>();
		categories = findCategory(portfolioName);
		
		return categories;
		
	}
	
	public CategoryDTO getAllCategories(String portfolioName, String categoryName){
		List<CategoryDTO> categories = new ArrayList<>();
		CategoryDTO category = null;
		categories = findCategory(portfolioName);
		
		
		for(int i = 0; i< categories.size(); i++){
			if(categories.get(i).getCategoryName().equals(categoryName)){
				category = categories.get(i);
			}
		}
		return category;
	}
	private List<CategoryDTO>  findCategory(String portfolioName){
		for(int i = 0 ; i < portfolios.size(); i++){
			if(portfolios.get(i).getPortfolioName().equals(portfolioName)){
				 
				return  portfolios.get(i).getCategories();
			}
		}
		return null;
	}
}
