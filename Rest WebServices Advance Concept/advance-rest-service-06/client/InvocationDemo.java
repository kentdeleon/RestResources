package com.kent.advanceRest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kent.advanceRest.messenger.model.Message;

public class InvocationDemo {
	
	public static void main(String[] args) {
		
		Invocation invocation = prepareRequestForMessagesByYear(2017);
		Response response = invocation.invoke();
		System.out.println(response.getStatus());
//		Message readEntity = response.readEntity(Message.class);
//		System.out.println(readEntity.getMessage());
//		
	}
	
	public static Invocation prepareRequestForMessagesByYear(int year) {
		Client client = ClientBuilder.newClient();
		
		Invocation invocation = client.target("http://localhost:8080/advance-rest-service-06/v1/")
								 .path("messages")
								 .queryParam("year", year)
								 .request(MediaType.APPLICATION_JSON)
								 .buildGet();
		
		return invocation;
	}
}
