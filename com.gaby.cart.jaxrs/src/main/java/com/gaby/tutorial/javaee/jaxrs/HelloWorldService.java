package com.gaby.tutorial.javaee.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.gaby.tutorial.javaee.ejb.Cart;
import com.gaby.tutorial.javaee.servlet.ServiceFactory;

@Path("/sayhello")
public class HelloWorldService {

	@GET
	@Path("/{message}")
	public String echo(final @PathParam(value="message") String message) {
		Cart cart = (Cart) ServiceFactory.getInstance().getService("cart");
		return "hello " + cart.getContents();
	}
}
