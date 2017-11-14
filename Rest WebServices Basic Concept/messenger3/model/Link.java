package org.kent.restServices3.messenger3.model;

public class Link {

	private String link;
	private String rel;
	
	public Link() {
		
	}

	
	
	private Link(String link, String rel) {
		this.link = link;
		this.rel = rel;
	}
	
	public static Link generateLink(String link, String rel) {
		return new Link(link, rel);
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
}
