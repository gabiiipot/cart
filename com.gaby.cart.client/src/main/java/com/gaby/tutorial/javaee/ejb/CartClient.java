package com.gaby.tutorial.javaee.ejb;

import java.util.List;

import javax.naming.InitialContext;

public class CartClient {

	public static void main(String[] args) {
		try {
			InitialContext context = new InitialContext();
			Cart cart = (Cart) context.lookup("cart");

			cart.initialize("Gabi");
			cart.addBook("Gabi's Book");
			cart.addBook("Bob's Book");

			List<String> books = cart.getContents();
			System.out.println("Books: " + books);
			
			MyTimer timer = (MyTimer) context.lookup("timer");
			System.out.println("Creating timer");
			timer.createTimer(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
