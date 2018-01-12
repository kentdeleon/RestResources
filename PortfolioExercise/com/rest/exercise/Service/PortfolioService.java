package com.rest.exercise.Service;

import java.util.ArrayList;
import java.util.List;

import com.rest.exercise.DAO.ApplicationDAO;
import com.rest.exercise.DTO.ApplicationDTO;
import com.rest.exercise.DTO.CategoryDTO;
import com.rest.exercise.DTO.PortfolioDTO;

public class PortfolioService
{
	private List<PortfolioDTO> portfolios = ApplicationDAO.getPorfolios();
	
	public PortfolioService(){
		
		ApplicationDTO app1 = ApplicationDTO.createApplication("Zomato App", "E1E6DHXH1");
		ApplicationDTO app2 = ApplicationDTO.createApplication("Agoda App", "P1E7DHXH1");
		
		
		ApplicationDTO app3 = ApplicationDTO.createApplication("Auto Loan", "A2E6DH3D1");
		ApplicationDTO app4 = ApplicationDTO.createApplication("Housing Loan", "A2E6DH3D2");
		
		ApplicationDTO app5 = ApplicationDTO.createApplication("Clash of Clans", "E1E6DHXH1");
		ApplicationDTO app6 = ApplicationDTO.createApplication("Clash Royale", "P1E7DHXH1");
		
		CategoryDTO category = CategoryDTO.createCategory("Mobile Category");
		category.addApplication(app1);
		category.addApplication(app2);
		CategoryDTO mobileGameCategory = CategoryDTO.createCategory("Mobile Games Category");
		mobileGameCategory.addApplication(app5);
		mobileGameCategory.addApplication(app6);
		
		CategoryDTO loanCategory = CategoryDTO.createCategory("Loan Category");
		loanCategory.addApplication(app3);
		loanCategory.addApplication(app4);
		
		PortfolioDTO portfolio = PortfolioDTO.createPortfolio("Mobile Portfolio");
		portfolio.addCategory(category);
		portfolio.addCategory(mobileGameCategory);
		
		PortfolioDTO loanPortfolio = PortfolioDTO.createPortfolio("Loan Portfolio");
		loanPortfolio.addCategory(loanCategory);
		
		portfolios.add(portfolio);
		portfolios.add(loanPortfolio);
	}

	public List<PortfolioDTO> getAllPortfolios(){
		return new ArrayList<PortfolioDTO>(portfolios);
	}
	
	private PortfolioDTO findPortfolio(String portfolioName){
		for(int i = 0 ; i <portfolios.size(); i++){
			if(portfolios.get(i).getPortfolioName().equals(portfolioName)){
				return portfolios.get(i);
			}
		}
		return null;
	}
	public PortfolioDTO getPortofolio(String portfolioName){
		PortfolioDTO portfolio = findPortfolio(portfolioName);
		
		return portfolio;
	}
}
