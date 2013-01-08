package com.gaby.tutorial.javaee.ejb;

public class BookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7625557569366224712L;
	
	public BookException(String message) {
		super(message);
		System.err.println("Exception: " + message);
	}

}
