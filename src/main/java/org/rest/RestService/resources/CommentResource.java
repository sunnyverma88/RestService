package org.rest.RestService.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	
	@GET
	public String test()
	{
	return "test";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") int commentId,
						@PathParam("postId") int postId)
	{
		return "CommentID : "+ commentId +"  Post ID : "+postId ;
		
		
	}
	
	
	
}
