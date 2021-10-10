package com.devsuperior.bds02.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException( String message ) {
		super(message);
	}
}