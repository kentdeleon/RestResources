package org.kent.restServices3.messenger3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.kent.restServices3.messenger3.database.DatabaseClass;
import org.kent.restServices3.messenger3.exception.DataNotFoundException;
import org.kent.restServices3.messenger3.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1L,"Welcome Kent", "kent.deleon"));
		messages.put(2L, new Message(2L,"Welcome Louis", "kent.deleon"));
		messages.put(3L, new Message(3L,"Welcome De Leon", "kent.deleon"));
		messages.put(4L, new Message(4L,"Welcome De Leon", "kent.deleon"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getPaginatedMessage(int start, int size){
		List<Message> messageList = new ArrayList<>(messages.values());
		if(start + size > messageList.size()){
			return new ArrayList<>();
		}
		
		return messageList.subList(start, start+size);
	}
	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null) {
			String errorMessage = "Unable to get the message \n";
			errorMessage += "Message with messsage id: " + id + " not found";
			throw new DataNotFoundException(errorMessage);
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		message.setUpdated();
		Message oldMessage = messages.get(message.getId());
		message.setCreated(oldMessage.getCreated());
		message.setLinks(oldMessage.getLinks());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		
		Message retrieveMessage = messages.get(id);
		if(retrieveMessage == null) {
			String errorMessage = "Unable to remove the message \n";
			errorMessage += "Message with messsage id: " + id + " not found";
			throw new DataNotFoundException(errorMessage);
		}
		messages.remove(id);
		return retrieveMessage;
	}
	
	
}	
