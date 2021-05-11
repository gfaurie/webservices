package com.webservices.exception;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String object, Long id) {
		super("Could not find " + object + " " + id);
	}

}
