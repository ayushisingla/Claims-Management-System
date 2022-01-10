package com.ayushi.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class contains test cases for the Claim model class which are written
 * using junit
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimTest {

	@Mock
	Claim claim;

	/**
	 * Checking if Claim class is loading or not.
	 */
	@Test
	@DisplayName("Checking if Claim class is loading or not.")
	void claimIsLoadedOrNot() {
		assertThat(claim).isNotNull();
	}

	@BeforeEach
	void setUp() throws Exception {
		claim = new Claim(2, "Pending Action", "claim has been submitted! Please check after few days for confirmation",
				1, 2, 202, 1, 60000.0, 60000.0);
	}

	/**
	 * 
	 * Testing Claim Constructor
	 */
	@Test
	public void testBenefitsConstructor() {
		assertEquals(2, claim.getClaimId());
		assertEquals("Pending Action", claim.getClaimStatus());
		assertEquals("claim has been submitted! Please check after few days for confirmation", claim.getDescription());
		assertEquals(1, claim.getPolicyId());
		assertEquals(2, claim.getMemberId());
		assertEquals(202, claim.getBenefitId());
		assertEquals(1, claim.getProviderId());
		assertEquals(60000.0, claim.getAmountClaimed());
		assertEquals(60000.0, claim.getAmountSettled());
	}

	/**
	 * 
	 * Testing Getters and setters
	 */
	@Test
	public void testGettersSetters() {
		claim.setPolicyId(1);
		claim.setMemberId(1);
		claim.setClaimId(1);
		claim.setBenefitId(202);
		claim.setAmountClaimed(10000.0);
		claim.setAmountSettled(10000.0);
		claim.setClaimStatus("Pending Action");
		claim.setDescription("claim has been submitted! Please check after few days for confirmation");
		claim.setProviderId(1);
		assertEquals(claim.getClaimId(), 1);
		assertEquals(claim.getPolicyId(), 1);
		assertEquals(claim.getMemberId(), 1);
		assertEquals(claim.getBenefitId(), 202);
		assertEquals(claim.getAmountSettled(), 10000.0);
		assertEquals(claim.getAmountClaimed(), 10000.0);
		assertEquals(claim.getClaimStatus(), "Pending Action");
		assertEquals(claim.getDescription(), "claim has been submitted! Please check after few days for confirmation");
		assertEquals(claim.getProviderId(), 1);
	}

}
