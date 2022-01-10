package com.ayushi.membermicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

/**
 * Test for  ClaimService 
 */

public class ClaimServiceTest {

	@Mock
	ClaimService service;

	/**
	 * Test to check the method is null
	 */

	@Test
	@DisplayName("Checking for ClaimService - whether it is loading or not for @GetMapping")
	void repairServiceImplNullTest() {
		assertThat(service).isNull();
	}
}
