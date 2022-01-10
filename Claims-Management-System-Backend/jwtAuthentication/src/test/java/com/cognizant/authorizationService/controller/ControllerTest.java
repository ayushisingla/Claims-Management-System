package com.ayushi.authorizationService.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.authorizationService.exception.BadCredentialException;
import com.ayushi.authorizationService.exception.LoginException;
import com.ayushi.authorizationService.model.AuthenticationRequest;
import com.ayushi.authorizationService.service.JwtUtil;
import com.ayushi.authorizationService.service.MyUserDetailsService;
import com.ayushi.authorizationService.service.ValidateService;
/**
 * This class contains junit test cases for the AuthenticationController class 
 * 
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ControllerTest {
	@Mock
	private AuthenticationManager authenticationManager;

	@Mock
	private JwtUtil jwtTokenUtil;

	@Mock
	private MyUserDetailsService userDetailsService;

	@Mock
	private ValidateService validateService;
	@InjectMocks
	private AuthenticationController authcontroller;

	@Test
	void testValidLogin() throws BadCredentialException, LoginException  {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "admin1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("dummy-token");

		ResponseEntity<?> authenticationResponse = authcontroller.createAuthenticationToken(authenticationRequest);
		assertEquals(HttpStatus.OK, authenticationResponse.getStatusCode());
	}

	@Test
	void testInvalidLogin() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "user1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(),"admin1", new ArrayList<>());
		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);
		/* when(jwtTokenUtil.generateToken(userDetails)).thenReturn("dummy-token"); */
		LoginException thrown = Assertions.assertThrows(LoginException.class,
				() -> authcontroller.createAuthenticationToken(authenticationRequest));
		assertEquals("Invalid Username or Password", thrown.getMessage());
		
	}
	
	@Test
	void testValidToken() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "admin1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("token");
		when(jwtTokenUtil.validateToken("token")).thenReturn(true);
		when(jwtTokenUtil.extractUsername("token")).thenReturn("admin1");
		when(userDetailsService.loadUserByUsername("admin1")).thenReturn(userDetails);

		ResponseEntity<?> validity = authcontroller.createAuthenticationToken(authenticationRequest);
		assertEquals(HttpStatus.OK,validity.getStatusCode());
	}

	@Test
	void testInvalidToken() throws BadCredentialException, LoginException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("name1", "name1");
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		when(jwtTokenUtil.generateToken(userDetails)).thenReturn("token");
		when(jwtTokenUtil.validateToken("mhgvuygy")).thenReturn(false);
		when(jwtTokenUtil.extractUsername("token")).thenReturn("name1");
		when(userDetailsService.loadUserByUsername("name1")).thenReturn(userDetails);

		ResponseEntity<?> validity = authcontroller.createAuthenticationToken(authenticationRequest);
		assertEquals(false, validity.getBody().toString().contains("false"));
	}
}