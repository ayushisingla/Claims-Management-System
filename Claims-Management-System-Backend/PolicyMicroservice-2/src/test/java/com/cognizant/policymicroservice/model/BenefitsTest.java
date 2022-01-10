package com.ayushi.policymicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for Benefits class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BenefitsTest {

	@Mock
	public Benefits benefits;
	
	/*
	 * test the benefits class is loading or not
	 */
	@Test
	@DisplayName("Checking if benefits is loading or not.")
	 void benefitsIsLoaded() {
		assertThat(benefits).isNotNull();
	}
	
	/*
	 * test if benefits class is working or not
	 */
	@Test
	@DisplayName("Checking if Benefits class is working properly")
	void testBenefits() {
		benefits = new Benefits(201, "Free Monthly Health Checkup");
		assertEquals(201, benefits.getBenefitId());
		assertEquals("Free Monthly Health Checkup", benefits.getBenefitName());
	}
}
