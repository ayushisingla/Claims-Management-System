package com.ayushi.claimsmicroservice.exception;

public class BenefitsNotFoundException  extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public BenefitsNotFoundException(String msg) {
		super(msg);
		
	}
	
	public BenefitsNotFoundException() {
		super();
		
	}

}
