package org.kent.restServices3.messenger3.database;

import java.util.HashMap;
import java.util.Map;

import org.kent.restServices3.messenger3.model.Message;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();
	
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
}
