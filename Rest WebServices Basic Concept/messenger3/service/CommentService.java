package org.kent.restServices3.messenger3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kent.restServices3.messenger3.database.DatabaseClass;
import org.kent.restServices3.messenger3.exception.DataNotFoundException;
import org.kent.restServices3.messenger3.model.Comment;
import org.kent.restServices3.messenger3.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public CommentService() {
		Map<Long, Comment> comments = messages.get(1L).getComments();
		comments.put(1L, Comment.createCommentInstance(1L, "Comment 1", "kent.deleon"));
		comments.put(2L, Comment.createCommentInstance(2L, "Comment 2", "kent.deleon"));
		comments.put(3L, Comment.createCommentInstance(3L, "Comment 3", "kent.deleon"));
		
	}
	
//	private Comment findComment(long messageId, String content) {
//		Map<Long, Comment> comments = messages.get(messageId).getComments();
//		for(int i = 0 ; i < comments.size(); i++) {
//			if(comments.get(Long.valueOf(i)).getContent().equals(content)) {
//				return comments.get(Long.valueOf(i));
//			}
//		}
//		return null;
//		
//		
//	}
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,Comment> comments = messages.get(messageId).getComments();

		if(comments.size() <= 0) {
			throw new DataNotFoundException("Message for message id: " + messageId + " not found for fetching all comments");
		}
		return new ArrayList<Comment>(comments.values());
	}
	
	
	
	public Comment getComment(long messageId, long commentId) {
		Message message = messages.get(messageId);
		if(message == null) {
			throw new DataNotFoundException("Message for message id: " + messageId + " not found for fetching comment " + commentId);
		}
		Comment comment = message.getComments().get(commentId);
		if(comment == null) {
			throw new DataNotFoundException("comment id not found " + commentId);
		}
		
		return comment;
		
	}
	
	public Comment addComment(long messageId, Comment newComment) {
			Map<Long, Comment> comments = messages.get(messageId).getComments();
			newComment.setId(comments.size() + 1);
			newComment.setDateCreated();
			comments.put(newComment.getId(), newComment);
			return newComment;

	}
	
	public Comment updateComment(long messageId, long commentId,Comment newComment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comments == null) {
			throw new DataNotFoundException("message Id: " + messageId + " not found");
		}
		Comment oldComment = comments.get(commentId);
		if(oldComment == null) {
			throw new DataNotFoundException("comment Id: " + commentId + " not found");
		}
		
		newComment.setDateCreated(oldComment.getDateCreated());
		newComment.setDateUpdated();
		comments.put(commentId, newComment);
		return newComment;
		
	}
	
	public boolean removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comments == null) {
			throw new DataNotFoundException("Delete fail! message id " + messageId + "not found");
		}
		
		Comment commentToBeDelete = comments.get(commentId);
		if(commentToBeDelete == null) {
			throw new DataNotFoundException("Delete fail! comment id " + commentId + "not found");
		}
		
		 comments.remove(commentId,commentToBeDelete);
		 return true;
		
		
	}
}
 