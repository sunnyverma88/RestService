package org.rest.RestService.service;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rest.RestService.model.Post;
import org.rest.RestService.utils.Utility;



public class PostService {
	
	SessionFactory sessionFactory=Utility.createSessionFactory();
	 Session session;
	public List<Post> getAllPosts()
	{  
	
		session=sessionFactory.openSession();
		session.beginTransaction();
		List<Post> posts=session.createQuery("from Post p").list();
		session.close();
		System.out.println(posts.size());
		return posts;
	}
	public List<Post> getAllPostsPaginated(int start,int size)
	{  
	
		session=sessionFactory.openSession();
		session.beginTransaction();
		List<Post> posts=session.createQuery("from Post p").list();
		session.close();
		System.out.println(posts.size());
		if(start+size> posts.size())return new ArrayList<Post>();
		return posts.subList(start, size);
	}
	 public List<Post> getAllPostForUser(int userID)
	 {
		 session=sessionFactory.openSession();
			session.beginTransaction();
			
			Query query=session.createQuery("from Post p where user_Id = :userID");
			query.setInteger("userID", userID);
			List<Post> posts=query.list();
			session.close();
			System.out.println(posts.size());
			return posts;
	 }
	public Post getPost(int post_id)
	{   session=sessionFactory.openSession();
	     session.beginTransaction();
		Post post=(Post) session.get(Post.class,post_id);
		System.out.println(post.toString());
		session.close();
		return post;
		
	}
	
	public Post addPost(Post post) throws Exception
	{
		
		 session=sessionFactory.openSession();
	     session.beginTransaction();
	     session.save(post);
	     session.getTransaction().commit();
	     session.close();
		return post;
	}
	
	public Post updatePost(Post post) throws Exception
	{
		
		 session=sessionFactory.openSession();
	     session.beginTransaction();
	     session.saveOrUpdate(post);
	     session.getTransaction().commit();
	     session.close();
		return post;
	}
	
	public void deletePost(int postId) throws Exception
	{
		
		 session=sessionFactory.openSession();
	     session.beginTransaction();
	     Post post=(Post) session.load(Post.class,postId);
	     session.delete(post);
	     session.getTransaction().commit();
	     session.close();
		
	}

}
