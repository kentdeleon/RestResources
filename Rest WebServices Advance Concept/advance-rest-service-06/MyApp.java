package com.kent.advanceRest;



import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.kent.advanceRest.messenger.resources.CommentResource;
import com.kent.advanceRest.messenger.resources.MessageResource;
import com.kent.advanceRest.messenger.resources.ProfileResource;

@ApplicationPath("v1")
public class MyApp extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<>();
		s.add(MyResource.class);
		s.add(CommentResource.class);
		s.add(MessageResource.class);
		s.add(ProfileResource.class);
		return s;
	}


	

}
