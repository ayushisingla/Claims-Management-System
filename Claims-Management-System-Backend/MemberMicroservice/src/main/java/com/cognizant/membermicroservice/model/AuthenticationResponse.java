package com.ayushi.membermicroservice.model;

/**
 * This is a model class which will be used for generating response for the
 * authentication request.
 * 
 */

public class AuthenticationResponse {
	/**
	 * This will be the token necessary for login.
	 */
	private String jwtToken;
	/**
	 * This will be the boolean type value to check weather the token is valid or
	 * not.
	 */
	private Boolean valid;

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public AuthenticationResponse(String jwtToken, Boolean valid) {
		super();
		this.jwtToken = jwtToken;
		this.valid = valid;
	}

	public AuthenticationResponse() {
		super();
	}

}
