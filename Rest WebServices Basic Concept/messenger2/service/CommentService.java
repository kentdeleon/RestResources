package org.kent.restServices.messenger2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.kent.restServices.messenger2.database.DatabaseClass;
import org.kent.restServices.messenger2.model.Message;
import org.kent.restServices.messenger2.model.Comment;
import org.kent.restServices.messenger2.model.ErrorMessage;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public CommentService() {
		Map<Long, Comment> comments = messages.get(1L).getComments();
		comments.put(1L, new Comment(1L,"Comment Message 1", "Kent" ));
		comments.put(2L, new Comment(2L,"Comment Message 2", "Kent" ));
		
	}
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
		
	}
	
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage = new ErrorMessage("Not Found", 404, "https:kent.louis.com");
		Response response =  Response.status(Status.NOT_FOUND)
				.entity(errorMessage).
				build();
		
		Message message = messages.get(messageId);
		if(message == null) {
			throw new WebApplicationException(response); //second way
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment =  comments.get(commentId);
		
		if(comment == null) {
			throw new NotFoundException(response); //thirdway
		}
		
		return comment;
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comment.setCreated();
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <= 0) {
			return null;
		}
	
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
	
}