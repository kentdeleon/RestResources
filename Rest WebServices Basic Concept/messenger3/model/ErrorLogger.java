package org.kent.restServices3.messenger3.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorLogger {
	
	private String message;
	private int errorCode;
	
	
	public ErrorLogger() {
		
	}
	
	public ErrorLogger(String message, int errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	

}
