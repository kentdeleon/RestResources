package com.rest.exercise.Service;

import java.util.ArrayList;
import java.util.List;

import com.rest.exercise.DAO.ApplicationDAO;
import com.rest.exercise.DTO.ApplicationDTO;
import com.rest.exercise.DTO.CategoryDTO;
import com.rest.exercise.DTO.PortfolioDTO;

public class ApplicationService
{
	private List<PortfolioDTO> portfolios = ApplicationDAO.getPorfolios();
	
	
	public ApplicationService(){
		List<CategoryDTO> categories = new ArrayList<>();
		List<ApplicationDTO> applications = new ArrayList<>();
		
		for(int i = 0; i <portfolios.size(); i++){
			categories.addAll(portfolios.get(i).getCategories());
			for(int j = 0; j < categories.size(); j++){
				applications.addAll(categories.get(j).getApplications());
			}
		}
	}
	public List<ApplicationDTO> getAllApplications(String portfolioName, String categoryName){
		List<ApplicationDTO> applications = findApplication(portfolioName,categoryName);
		return applications;
	}
	private List<ApplicationDTO> findApplication(String portfolioName, String categoryName){
		List<CategoryDTO> categories = new ArrayList<>();
		List<ApplicationDTO> applications = new ArrayList<>();
		
		for(int i = 0 ; i < portfolios.size(); i++){
			if(portfolios.get(i).getPortfolioName().equals(portfolioName)){
				categories.addAll(portfolios.get(i).getCategories());
			}		
			
		}
		
		for(int i = 0; i < categories.size(); i++){
			if(categories.get(i).getCategoryName().equals(categoryName)){
				applications.addAll(categories.get(i).getApplications());
				return applications;
			}
		}
		
			return null;
		
	}
	
}
