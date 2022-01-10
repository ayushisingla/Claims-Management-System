package com.ayushi.authorizationService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.authorizationService.exception.BadCredentialException;
import com.ayushi.authorizationService.exception.LoginException;
import com.ayushi.authorizationService.model.AuthenticationRequest;
import com.ayushi.authorizationService.model.AuthenticationResponse;
import com.ayushi.authorizationService.service.JwtUtil;
import com.ayushi.authorizationService.service.MyUserDetailsService;
import com.ayushi.authorizationService.service.ValidateService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
/**
 * 
 * This class handles all the REST end points for JwtAuthentication Microservice. 
 * This Controller has mapping as -
 * postmapping-createAuthenticationToken()
 * getmapping-getValidity()
 * 
 */
public class AuthenticationController {
	
	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	AuthenticationController (){
	}
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private ValidateService validateService;

	/**
	 * @param authenticationRequest
	 * After successfull validation of both username and password this will create a token
	 * if incase the userdetails are  incorrect it will through loginException
	 * 
	 */
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws BadCredentialException, LoginException {

		logger.info("Creating token");

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialException("Bad Credential Exception ");
			
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		if (userDetails.getPassword().equals(authenticationRequest.getPassword())) {
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			logger.debug("token {}", jwt);

			return ResponseEntity.ok(new AuthenticationResponse(jwt, true));
		} else {
			throw new LoginException("Invalid Username or Password");
		}
	}
	
	/**
	 * @param token - to validate the token
	 * Sends the request header as "Authorization"
	 * and returns the validity of token
	 */
	@GetMapping("/validate")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token) {
		return validateService.validate(token);
	}

}
