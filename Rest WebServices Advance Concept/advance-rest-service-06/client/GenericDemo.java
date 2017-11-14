package com.kent.advanceRest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kent.advanceRest.messenger.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		
		List<Message> response = client.target("http://localhost:8080/advance-rest-service-06/v1/")
			  .path("messages")
			  .queryParam("year", 2017)
			  .request(MediaType.APPLICATION_JSON)
			  .get(new GenericType<List<Message>>() {});
		
		//System.out.println(response.size());
		
		for(Message m: response) {
			System.out.println(m.getMessage());
		}

	}

}
