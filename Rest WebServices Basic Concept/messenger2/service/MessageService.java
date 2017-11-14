package org.kent.restServices.messenger2.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;

import org.kent.restServices.messenger2.database.DatabaseClass;
import org.kent.restServices.messenger2.exception.DataNotFoundException;
import org.kent.restServices.messenger2.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Kent"));
		messages.put(2L, new Message(2, "Hello Jersey", "Louis"));
	}

	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messageList = new ArrayList<>(messages.values());
		if(start + size > messageList.size()) {
			return new ArrayList<>();
		}
		return messageList.subList(start, start + size);
		
	}
	
	public Message getMessage(long id) {
	
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("Message with message id " + id + " not found");
			
		}
		
		return message;
	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		message.setCreated();
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	 
}
