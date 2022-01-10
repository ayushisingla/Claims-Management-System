package com.ayushi.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * This is the model class for AuthenticationRequest
 */ 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {
/**
* This will be the username
*/ 
	private String username;
/**
* This will be the password
*/ 
	private String password;

}
