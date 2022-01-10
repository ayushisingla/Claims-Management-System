package com.ayushi.membermicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.membermicroservice.client.AuthClient;

/**
 * 
 * This class junit contains test cases for the AuthenticationResponse model class
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse response;

	@Mock
	private AuthClient authClient;

	/**
	 * 
	 * To Test allargsConstructor
	 */

	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(response.getValid(), auth.getValid());
		assertEquals(response.getJwtToken(), auth.getJwtToken());

	}

	/**
	 * 
	 * To Test noargsConstructor
	 */

	@Test
	public void testNoArgsConstructor() {

		AuthenticationResponse response = new AuthenticationResponse();
		assertEquals(response, response);
	}

	/**
	 * 
	 * To Test AuthenticationRequest Equals method
	 */

	@Test
	public void testEqualsMethod() {
		boolean equals = response.equals(response);
		assertTrue(equals);
	}
	
	/**
	 * To Test AuthenticationRequest hashCode method
	 */

	@Test
	public void testHashCodeMethod() {
		int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}

	@BeforeEach
	void setUp() {
		response = new AuthenticationResponse();
		response.setJwtToken("Token");
		response.setValid(true);
	}

}
