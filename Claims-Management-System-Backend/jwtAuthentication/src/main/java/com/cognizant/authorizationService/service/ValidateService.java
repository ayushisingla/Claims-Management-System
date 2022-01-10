package com.ayushi.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayushi.authorizationService.model.AuthenticationResponse;

/**
 * This class validate the service and return authentication response
 */ 
@Component
public class ValidateService {
	@Autowired
	private JwtUtil jwtutil;
	
	 /**
	 * @param token
	 * compare the token
	 * returns the authenticationResponse
	 */ 
	public AuthenticationResponse validate(String token) {
		var authenticationResponse = new AuthenticationResponse();
		var jwt = token.substring(7);
		authenticationResponse.setJwtToken(jwt);
		authenticationResponse.setValid(jwtutil.validateToken(jwt));
		return authenticationResponse;
	}
}
