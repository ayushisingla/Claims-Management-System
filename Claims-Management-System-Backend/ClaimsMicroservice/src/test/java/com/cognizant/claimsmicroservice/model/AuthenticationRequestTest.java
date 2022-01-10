package com.ayushi.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the AuthenticationRequest model class
 * which are written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationRequestTest {

	@Mock
	public AuthenticationRequest authreq;

	/**
	 * 
	 * test the AuthenticationRequest is not null
	 */

	@Test
	@DisplayName("Checking if AuthenticationRequest class is loading or not.")
	void AuthentictionRequestIsLoadedOrNot() {
		assertThat(authreq).isNotNull();
	}

	/**
	 * 
	 * test the AuthenticationRequest all argsConstructor
	 */

	@DisplayName("Checking if AuthenticationRequest class is responding correctly or not.")
	@Test
	void testingAuthenticationRequest() {
		authreq = new AuthenticationRequest("abhishek", "abhishek");
		authreq.setUsername("admin");
		authreq.setPassword("admin");

		assertEquals("admin", authreq.getUsername());
		assertEquals("admin", authreq.getPassword());
	}

	/**
	 * 
	 * test the AuthenticationRequest no argsConstructor
	 */

	@Test
	public void testNoArgConstructor() {
		AuthenticationRequest ulc = new AuthenticationRequest();
		assertEquals(ulc, ulc);
	}
}
