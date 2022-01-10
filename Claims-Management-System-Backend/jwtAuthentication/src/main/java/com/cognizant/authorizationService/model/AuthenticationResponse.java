package com.ayushi.authorizationService.model;

/**
 * This is the model class for AuthenticationResponse
 */ 
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;
	
	/**
	 * Returns Jwt token
	 * get jwtToken
	 */ 
	public String getJwtToken() {
		return jwtToken;
	}
	
	/**
	 * @param jwtToken
	 * set jwtToken
	 * return jwtToken
	 */ 
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	/**
	 * get valid
	 * returns valid
	 */ 
	public Boolean getValid() {
		return valid;
	}
	
	/**
	 * @param valid
	 * set valid
	 * returns valid
	 */ 
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	/**
	 *All ArgsConstructor
	 */ 
	public AuthenticationResponse(String jwtToken, Boolean valid) {
		super();
		this.jwtToken = jwtToken;
		this.valid = valid;
	}
	/**
	* No ArgsConstructor
	*/ 
	public AuthenticationResponse() {
		super();
	}

	
	
}
