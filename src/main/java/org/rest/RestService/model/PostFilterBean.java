package org.rest.RestService.model;

import javax.ws.rs.QueryParam;

public class PostFilterBean {
  
	private @QueryParam("start") int start ; 
	private @QueryParam("size") int size;
	private @QueryParam("userId") int userID;
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
