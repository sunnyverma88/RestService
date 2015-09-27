package org.rest.RestService.resources;
import org.glassfish.jersey.server.Uri;
import org.rest.RestService.model.Post;
import org.rest.RestService.model.PostFilterBean;

import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import javax.ws.rs.core.UriInfo;

import org.rest.RestService.service.PostService;

@Path("posts")
public class PostResource {

	
	PostService ps=new PostService();
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts()
	{   
		return ps.getAllPosts();
	}*/
	
	//Example of @BeanParam
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts(@BeanParam PostFilterBean pfb)
	{   
			
		if(pfb.getStart() >=0 && pfb.getSize() >0)
		{
			System.out.println("test2 : "+pfb.getStart());
			return ps.getAllPostsPaginated(pfb.getStart(),pfb.getSize());
		}
		if(pfb.getUserID()>0)
		{
			return ps.getAllPostForUser(pfb.getUserID());
		}
		return ps.getAllPosts();
	}
	
	
	//Example To set Status Codes and set Header Information - i.e. NEW URL for the added message
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPosts(Post post,@Context UriInfo uri) throws Exception
	{   
		Post newPost=ps.addPost(post);
		String newID=String.valueOf(post.getPost_id());
		URI location=uri.getAbsolutePathBuilder().path(newID).build();
		return Response.created(location).header("error","CREATED")
		.entity(newPost).build();
		
	}
	
	@PUT
	@Path("/{postId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post updatePosts(@PathParam("postId") int postId,Post post) throws Exception
	{   
		post.setPost_id(postId);
		return ps.updatePost(post);
	}
	
	@DELETE
	@Path("/{postId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void removePosts(@PathParam("postId") int postId) throws Exception
	{   
		ps.deletePost(postId);
	}
	
	
	@GET
	@Path("/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
    public Post Test(@PathParam("postId") int postId )
	{
		return ps.getPost(postId);
	}
	
	
	@Path("/{postId}/comments")
	@Produces(MediaType.TEXT_PLAIN)
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
