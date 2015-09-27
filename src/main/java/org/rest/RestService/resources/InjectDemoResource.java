package org.rest.RestService.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectDemo")

public class InjectDemoResource {
    
	
	@GET
	@Path("annotation")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamUsingAnnotation(@MatrixParam("name") String mtrxParam,
			@HeaderParam("authID") String authID,
			@CookieParam("ckie") String ckie)		
	{
		return "Matrix Param : " + mtrxParam + "   Auth ID   :" +authID +"  Cookie Param   :"+ckie;
	}
	
	@GET
	@Path("context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamUsingContext(@Context UriInfo uriInfo)		
	{
		return uriInfo.getAbsolutePath().toString();
	}
	
	
	
}
