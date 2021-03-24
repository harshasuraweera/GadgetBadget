package it19208718;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/HelloHarsha")
public class HelloHarsha {

	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello()
	{
	return "Hello Harsha";
	}
}
