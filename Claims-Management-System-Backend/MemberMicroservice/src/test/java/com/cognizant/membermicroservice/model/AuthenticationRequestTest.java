package com.ayushi.membermicroservice.model;

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
 * This class contains junit test cases for the AuthenticationRequest model class
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationRequestTest {

	@Mock
	public AuthenticationRequest authreq;

	/**
	 * 
	 * To Test AuthenticationRequest is not null
	 */

	@Test
	@DisplayName("Checking if AuthenticationRequest class is loading or not.")
	void AuthentictionRequestIsLoadedOrNot() {
		assertThat(authreq).isNotNull();
	}

	/**
	 * 
	 * To Test AuthenticationRequest all argsConstructor
	 */

	@DisplayName("Checking if AuthenticationRequest class is responding correctly or not.")
	@Test
	void testingAuthenticationRequest() {
		authreq = new AuthenticationRequest("Riteesh", "Riteesh");
		authreq.setUsername("admin");
		authreq.setPassword("admin");

		assertEquals("admin", authreq.getUsername());
		assertEquals("admin", authreq.getPassword());
	}

	/**
	 * 
	 * To Test AuthenticationRequest no argsConstructor
	 */

	@Test
	public void testNoArgConstructor() {
		AuthenticationRequest ulc = new AuthenticationRequest();
		assertEquals(ulc, ulc);
	}
}
