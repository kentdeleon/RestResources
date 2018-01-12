package com.rest.exercise.DAO;

import java.util.ArrayList;
import java.util.List;

import com.rest.exercise.DTO.PortfolioDTO;

public class ApplicationDAO
{
	private static List<PortfolioDTO> portfolios= new ArrayList<>();
	
	public static List<PortfolioDTO> getPorfolios(){
		return portfolios;
	}
	
	

}
