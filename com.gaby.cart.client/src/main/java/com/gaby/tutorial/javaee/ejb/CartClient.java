package com.gaby.tutorial.javaee.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class CartClient {
	
	private static final int NUM_MSGS = 5;

	@Resource(mappedName="jms/ConnectionFactory")
	private static ConnectionFactory connectionFactory;

	@Resource(mappedName="jms/Queue")
	private static Queue queue;

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
			
			ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/ConnectionFactory");
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false,
			    Session.AUTO_ACKNOWLEDGE);
			
			Queue queue = (Queue) context.lookup("jms/Queue");
			MessageProducer messageProducer = session.createProducer(queue);
			
			TextMessage message = session.createTextMessage();

			for (int i = 0; i < NUM_MSGS; i++) {
			    message.setText("This is message " + (i + 1));
			    System.out.println("Sending message: " +
			        message.getText());
			    messageProducer.send(message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
