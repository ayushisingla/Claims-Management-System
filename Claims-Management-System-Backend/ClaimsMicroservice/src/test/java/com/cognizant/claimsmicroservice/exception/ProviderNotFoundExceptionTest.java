package com.ayushi.claimsmicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProviderNotFoundExceptionTest {

	@Mock
	private ProviderNotFoundException providerNotFoundException;

	@Test
	public void testOneArgConstructor() {
		providerNotFoundException = new ProviderNotFoundException("provider Not Found.");
		assertEquals("provider Not Found.", providerNotFoundException.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		providerNotFoundException = new ProviderNotFoundException();
		assertEquals(null, providerNotFoundException.getMessage());
	}
}
