package org.rest.RestService.resources;
import org.rest.RestService.model.Post;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.RestService.service.PostService;

@Path("posts")
public class PostResource {

	
	PostService ps=new PostService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Post> getPosts()
	{   
		return ps.getAllPosts();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Post addPosts(Post post) throws Exception
	{   
		return ps.addPost(post);
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
}
