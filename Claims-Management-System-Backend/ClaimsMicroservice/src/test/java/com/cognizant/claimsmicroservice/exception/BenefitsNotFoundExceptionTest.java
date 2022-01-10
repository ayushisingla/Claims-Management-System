package com.ayushi.claimsmicroservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class BenefitsNotFoundExceptionTest {

	@Mock
	private BenefitsNotFoundException benefitsNotFoundException;

	@Test
	public void testOneArgConstructor() {
		benefitsNotFoundException = new BenefitsNotFoundException("File Not Found.");
		assertEquals("File Not Found.", benefitsNotFoundException.getMessage());
	}

	@Test
	public void testNoArgConstructor() {
		benefitsNotFoundException = new BenefitsNotFoundException();
		assertEquals(null, benefitsNotFoundException.getMessage());
	}
}
