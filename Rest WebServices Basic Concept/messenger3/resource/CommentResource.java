package org.kent.restServices3.messenger3.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kent.restServices3.messenger3.helper.ResponseHelper;
import org.kent.restServices3.messenger3.model.Comment;
import org.kent.restServices3.messenger3.model.ErrorLogger;
import org.kent.restServices3.messenger3.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("/{commentId}")
	public Response getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		Comment comment =  commentService.getComment(messageId, commentId);
		return Response.ok(comment).build();
	}
	
	@POST
	public Response addComment(@PathParam("messageId") long messageId, Comment comment) {
		Comment newComment = commentService.addComment(messageId, comment);
		//return Response.status(Status.CREATED).entity(newComment).build();
		Response response = ResponseHelper.toResponse(Status.CREATED, newComment);
		return response;
	}
	

	@PUT	
	@Path("/{commentId}")
	public Response updateComment(@PathParam("messageId") long messageId, 
								  @PathParam("commentId") long commentId, 
								  Comment comment) {
		
		comment.setId(commentId);
		Comment updatedComment = commentService.updateComment(messageId, commentId, comment);
		return Response.status(Status.ACCEPTED).entity(updatedComment).build();
	}
	
	@DELETE
	@Path("/{commentId}")
	public Response removeComment(@PathParam("messageId") long messageId,
								  @PathParam("commentId") long commentId) {
		
		boolean isDeleted = commentService.removeComment(messageId, commentId);
		if(isDeleted) {
			//ErrorLogger deletedLogger = new ErrorLogger("Successfully Deleted", 202);
			Response response = ResponseHelper.toResponse("Comment Successfully Deleted for comment id: " + commentId, 202);
			//return Response.status(Status.ACCEPTED).entity(deletedLogger).build();
			return response;
		}
		
		return Response.status(Status.BAD_REQUEST).build();
	}
	
}
