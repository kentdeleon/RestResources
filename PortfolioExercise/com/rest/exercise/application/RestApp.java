package com.rest.exercise.application;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/v1")
public class RestApp extends Application{

	@Override
	public Set<Class<?>> getClasses()
	{
		// TODO Auto-generated method stub
		return super.getClasses();
	}
	

}
