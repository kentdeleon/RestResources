package org.kent.restServices3.messenger3.resource;

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
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.kent.restServices.messenger2.resources.CommentResource;
import org.kent.restServices.messenger2.resources.MessageResource;
import org.kent.restServices3.messenger3.bean.MessageFilterBean;
import org.kent.restServices3.messenger3.helper.ResponseHelper;
import org.kent.restServices3.messenger3.helper.UriGenerator;
import org.kent.restServices3.messenger3.model.Message;
import org.kent.restServices3.messenger3.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getPaginatedMessage(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	
	@GET
	@Path("/{messageId}")
	public Response getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageId);
		if(message.getLinks().size() == 0) {
			message.addLink(UriGenerator.getURI(uriInfo, this.getClass(), messageId), "self");
			message.addLink(UriGenerator.getURI(uriInfo, this.getClass(), messageId, "getCommentResource"), "comment");
		}
		Response response = ResponseHelper.toResponse(Status.OK, message);
		return response;
	}
	
//	private String getURI(UriInfo uriInfo, long messageId) {
//		return uriInfo.getBaseUriBuilder()
//						.path(this.getClass())
//						.path(Long.toString(messageId))
//						.build()
//						.toString();
//		
//		
//	}
	
//	private String getURIComment(UriInfo uriInfo, long messageId) {
//		System.out.println("getURI " + MessageResource.class);
//		return uriInfo.getBaseUriBuilder()
//				.path(MessageResource.class)
//				.path(MessageResource.class, "getCommentResource")
//				.resolveTemplate("messageId", messageId)
//				.build()
//				.toString();
//		
//		
//	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		newMessage.addLink(UriGenerator.getURI(uriInfo, this.getClass(), newMessage.getId()), "self");
		newMessage.addLink(UriGenerator.getURI(uriInfo, this.getClass(), newMessage.getId(), "getCommentResource"), "comment");
		Response response = ResponseHelper.toResponse(Status.CREATED, newMessage);
		return response;
	}
	
	@PUT
	@Path("/{messageId}")
	public Response updateMessage(@PathParam("messageId") long messageId, Message message) {
		message.setId(messageId);
		Message updatedMessage = messageService.updateMessage(message);
		return Response.accepted().entity(updatedMessage).build();
	}
	
	@DELETE
	@Path("/{messageId}")
	public Response removeMessage(@PathParam("messageId") long messageId) {
		Message deleteMessage = messageService.removeMessage(messageId);
		
		if(deleteMessage != null) {
			//return Response.accepted().entity(deleteMessage).build();
	
			Response response = ResponseHelper.toResponse("Message successfully deleted for message id " + messageId ,202);
			return response;
		}
		
		return Response.status(Status.NOT_FOUND).entity(deleteMessage).build();
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}

}
