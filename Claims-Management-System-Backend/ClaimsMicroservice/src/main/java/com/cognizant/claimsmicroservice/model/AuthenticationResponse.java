package com.ayushi.claimsmicroservice.model;

import lombok.Data;

@Data
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;

	public AuthenticationResponse(String jwtToken, Boolean valid) {
		super();
		this.jwtToken = jwtToken;
		this.valid = valid;
	}
	public AuthenticationResponse() {
		super();
	}

	
	
}
