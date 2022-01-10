package com.ayushi.claimsmicroservice.exception;

public class ProviderNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public ProviderNotFoundException(String msg) {

		super(msg);
	}
	public ProviderNotFoundException() {

		super();
	}

}
