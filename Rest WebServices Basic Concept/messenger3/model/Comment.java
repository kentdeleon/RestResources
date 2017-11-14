package org.kent.restServices3.messenger3.model;

import java.util.Date;

public class Comment {
	
	private long id;
	private String content;
	private Date dateCreated;
	private Date dateUpdated;
	private String author;
	
	public Comment() {
		
	}
	
	public Comment(long id, String content, String author) {
		this.id = id;
		this.content = content;
		this.author = author;
		this.dateCreated = new Date();
		this.dateUpdated = null;
	}
	
	public static Comment createCommentInstance(long id, String content, String author) {
		return new Comment(id,content, author);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setDateCreated() {
		this.dateCreated = new Date();
	}
	
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated() {
		this.dateUpdated = new Date();
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
