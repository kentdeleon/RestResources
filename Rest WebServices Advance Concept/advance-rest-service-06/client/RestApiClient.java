package com.kent.advanceRest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kent.advanceRest.messenger.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		
		
		//Advanced JAX-RS 14 - Writing a JAX-RS client
//		Response response = client.target("http://localhost:8080/advance-rest-service-06/v1/messages/1").request().get();
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getMessage());	
		
		
		//Advanced JAX-RS 15 - Client Code Explained Step By Step
//		
//		WebTarget target = client.target("http://localhost:8080/advance-rest-service-06/v1/messages/1");
//		Builder builder = target.request();
//		Response response = builder.get();
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getAuthor());
		
		//Back to code in 14
		//Response response = client
		//Message message = client
//		String message = client
//				.target("http://localhost:8080/advance-rest-service-06/v1/messages/2")
//				.request(MediaType.APPLICATION_JSON)
//				.get(String.class);
//		//Message message = response.readEntity(Message.class);
//		System.out.println(message);	
		
		
		//Advanced JAX-RS 16 - Some Best Practices
		
		WebTarget baseTarget = client.target("http://localhost:8080/advance-rest-service-06/v1");
		WebTarget messagesTarget = baseTarget.path("/messages");
		WebTarget singleMessageTarget = messagesTarget.path("/{messageId}");
		
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		//Message message = response.readEntity(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
//		System.out.println(message1.getMessage());
//		System.out.println(message2.getMessage());
		
		
		//Advanced JAX-RS 17 - Making a POST request
		
		Message newMessage = new Message(10, "My first post message from jax-rs client", "Kent");
		Response postResponse = messagesTarget
				.request()
				.post(Entity.json(newMessage));
		
		System.out.println(postResponse.readEntity(Message.class).getMessage());
		
		
	}

}
