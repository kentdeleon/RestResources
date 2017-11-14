package org.kent.restServices.messenger2.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.kent.restServices.messenger2.model.Message;

import org.kent.restServices.messenger2.resources.bean.MessageFilterBean;
import org.kent.restServices.messenger2.service.MessageService;

@Path("/messages") //Step 4
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	//Step 1 Add new Class
	//Step 2 add a method that returns the response
	//Step 3 Make sure your class is in the package configured in Jersey servlet's 
	//init-param(check web.xml)
	//Step 4 Annotate class with @Path annotation
	//Step 5 Annotate method with the right HTTP method annotation i.e. @GET
	//Step 6 Annotate method with the @Produces specifying the response format
	
	MessageService messageService = new MessageService();
	
//	@GET //Step 5
//	//@Produces(MediaType.APPLICATION_JSON) //Step 6
//	public List<Message> getMessages(@QueryParam("year") int year,
//									 @QueryParam("start") int start,
//									 @QueryParam("size") int size) { //Step 2
//		//return "Hello From " + getClass().getSimpleName();
//		if(year > 0) {
//			return messageService.getAllMessagesForYear(year);
//		}
//		if(start >= 0 && size > 0) {
//			return messageService.getAllMessagesPaginated(start, size);
//		}
//		return messageService.getAllMessages();
//	}
	
	//Implementation below using BeanParam

	
	@GET //Step 5
	@Produces(MediaType.APPLICATION_JSON) //Step 6
	public List<Message> getJSONMessages(@BeanParam MessageFilterBean filterBean) { //Step 2
		//return "Hello From " + getClass().getSimpleName();
		if(filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart() , filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET //Step 5
	@Produces(MediaType.TEXT_XML) //Step 6
	public List<Message> getXMLMessages(@BeanParam MessageFilterBean filterBean) { //Step 2
		//return "Hello From " + getClass().getSimpleName();
		if(filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart() , filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	

	
	//Implementing POST method
	@POST
//	public Message addMessage(Message message) {
//		return messageService.addMessage(message);
//	}
	
	//Implementing POST method with sending status code
	public Response addMessage(Message message, @Context UriInfo uriInfo)  {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
//		return Response.status(Status.CREATED)
//				.entity(newMessage)
//				.build();
		
		return Response.created(uri)
						.entity(newMessage)
						.build();
		
	}
	
	//Implementing PUT method
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	
	//Implementing DELETE method
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId) {
		messageService.removeMessage(messageId);
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageId);
		message.addLink(getURIForSelf(uriInfo, message), "self");
		message.addLink(getURIForProfile(uriInfo, message), "profile");
		message.addLink(getURIForComment(uriInfo, message), "comment");
		return message;
		
		//System.out.println(uriInfo.getAbsolutePath());
		//retrieveMessage.getLinks().add(new Link("","self"));
		//return "Got path param " + messageId;
		
		//return retrieveMessage;
	}


	private String getURIForComment(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(MessageResource.class, "getCommentResource")
					.path(CommentResource.class)
					.resolveTemplate("messageId", message.getId())
					.build()
					.toString();
	}


	private String getURIForProfile(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
					.path(ProfileResource.class)
					.path(message.getAuthor())
					.build()
					.toString();
	}


	private String getURIForSelf(UriInfo uriInfo, Message message) {
		return uriInfo.getBaseUriBuilder()
							.path(MessageResource.class)
							.path(Long.toString(message.getId()))
							.build()
							.toString();
		 
	}
	
	
//	@GET
//	@Path("/{messageId}/comments")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String test() {
//		return "test";
//	}
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	

}
