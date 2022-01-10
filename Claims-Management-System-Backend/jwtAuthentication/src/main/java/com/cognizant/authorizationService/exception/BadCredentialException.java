package com.ayushi.authorizationService.exception;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception class is called when system encountered for Bad Credentials
 */ 
@ResponseStatus(code=HttpStatus.NOT_FOUND , reason="Username or Password incorrect")
public class BadCredentialException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param exceptionMessage
	 * return exceptioMessage
	 */
	public BadCredentialException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
