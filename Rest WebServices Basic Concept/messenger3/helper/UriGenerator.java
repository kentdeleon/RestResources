package org.kent.restServices3.messenger3.helper;

import javax.ws.rs.core.UriInfo;

public class UriGenerator {
	
	public static String getURI(UriInfo uriInfo, Class resource,long messageId ) {
		return uriInfo.getBaseUriBuilder()
						.path(resource)
						.path(Long.toString(messageId))
						.build()
						.toString();
		
		
	}
	
	public static String getURI(UriInfo uriInfo, Class parentResource,long messageId, String subResourceMethod ) {
		return uriInfo.getBaseUriBuilder()
						.path(parentResource)
						.path(parentResource, subResourceMethod)
						.resolveTemplate("messageId", messageId)
						.build()
						.toString();
		
		
	}
}
