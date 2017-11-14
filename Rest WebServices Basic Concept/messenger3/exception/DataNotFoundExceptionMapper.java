package org.kent.restServices3.messenger3.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.kent.restServices3.messenger3.model.ErrorLogger;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException execeptionObject) {
		ErrorLogger errorLogger = new ErrorLogger(execeptionObject.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(errorLogger)
				.build();
	}
	
	

}
