package com.gaby.tutorial.javaee.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/echo")
public class HelloWorldService {

//	@EJB
//	private IBasicService service;

	@GET
	@Path("/{message}")
	public String echo(final @PathParam(value="message") String message) {		
		return "hello gabi";
	}
	

}
