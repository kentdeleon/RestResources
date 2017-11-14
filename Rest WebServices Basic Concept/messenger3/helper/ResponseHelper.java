package org.kent.restServices3.messenger3.helper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kent.restServices3.messenger3.model.Comment;
import org.kent.restServices3.messenger3.model.ErrorLogger;
import org.kent.restServices3.messenger3.model.Message;

public class ResponseHelper {
	
	public static Response toResponse(String message, int statusCode ) {
		ErrorLogger messageLogger = new ErrorLogger(message, statusCode);
		return Response.status(statusCode).entity(messageLogger).build();
	}
	
	public static Response toResponse(Status status, Comment comment) {
		return Response.status(status).entity(comment).build();
	}
	
	public static Response toResponse(Status status, Message message) {
		return Response.status(status).entity(message).build();
	}

}
