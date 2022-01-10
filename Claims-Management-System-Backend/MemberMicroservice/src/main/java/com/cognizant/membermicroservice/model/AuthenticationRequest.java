package com.ayushi.membermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a model class which will be used for generating authentication
 * request.
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

	/**
	 * This will be the username for login.
	 */
	private String username;
	/**
	 * This will be the password for login.
	 */
	private String password;

}
