package com.gaby.tutorial.javaee.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/sayhello")
public class HelloWorldService {

	@GET
	@Path("/{message}")
	public String echo(final @PathParam(value="message") String message) {		
		return "hello " + message;
	}
}
