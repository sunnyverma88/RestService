package org.rest.RestService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Post {
    @Id
    @GeneratedValue
	private int post_id;
	private String message;
	private Date created;
	private int user_id;
	
	public Post()
	{
		
	}
	
	public Post(int post_id, String message, Date created, int user_id) {
		super();
		
		this.message = message;
		this.created = created;
		this.user_id = user_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
