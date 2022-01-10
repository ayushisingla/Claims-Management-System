package com.ayushi.membermicroservice.exception;

/**
 * 
 * This class used to throw exception if the required data is not available this
 * class extends the RuntimeException class.
 *
 */

public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileNotFoundException() {
		super();
	}

	public FileNotFoundException(String message) {
		super(message);
	}

}
