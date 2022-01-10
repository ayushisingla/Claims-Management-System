package com.ayushi.policymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This is a model class which is used for authentication response
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;

}
