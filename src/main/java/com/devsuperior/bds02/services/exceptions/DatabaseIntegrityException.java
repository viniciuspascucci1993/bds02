package com.devsuperior.bds02.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseIntegrityException( String message ) {
		super(message);
	}
}
