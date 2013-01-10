package com.gaby.tutorial.javaee.servlet;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.gaby.tutorial.javaee.ejb.BookException;
import com.gaby.tutorial.javaee.ejb.Cart;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Cart cart;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServiceFactory factory = ServiceFactory.getInstance();
		assert(cart != null);
		factory.registerService("cart", cart);
		
		try {
			cart.initialize("Gabi", "123");
		} catch (BookException e) {
			e.printStackTrace();
		}
		cart.addBook("Gabi's Book");
		List<String> books = cart.getContents();
		System.out.println("Books: " + books);
	}
}
