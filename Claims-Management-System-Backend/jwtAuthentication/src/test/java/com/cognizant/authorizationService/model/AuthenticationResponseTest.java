package com.ayushi.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse response;

	
	
	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(response.getValid(), auth.getValid());
		assertEquals(response.getJwtToken(),auth.getJwtToken());

	}
	
	@Test
	public void testNoArgsConstructor() {
		
		final AuthenticationResponse response = new AuthenticationResponse();
		assertEquals(response, response);
	}
	
	@Test
	public void testEqualsMethod() {
		final boolean equals = response.equals(response);
		assertTrue(equals);
	}
	
	@Test
	public void testHashCodeMethod() {
		final int hashCode = response.hashCode();
		assertEquals(hashCode, response.hashCode());
	}
	
	@BeforeEach
	void setUp() {
		response = new AuthenticationResponse();
		response.setJwtToken("Token");
		response.setValid(true);
	}
	
}
