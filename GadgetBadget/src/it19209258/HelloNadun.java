package it19209258;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/HelloNadun")
public class HelloNadun {

	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{
	return "Hello Nadun";
	}
}
