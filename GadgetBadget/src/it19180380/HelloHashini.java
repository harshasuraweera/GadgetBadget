package it19180380;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/HelloHashini")
public class HelloHashini {

	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{
	return "Hello Hashini";
	}
}
