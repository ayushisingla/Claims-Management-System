package com.ayushi.claimsmicroservice.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.claimsmicroservice.client.PolicyClient;
import com.ayushi.claimsmicroservice.dto.ClaimStatusDTO;
import com.ayushi.claimsmicroservice.exception.ProviderNotFoundException;
import com.ayushi.claimsmicroservice.model.Benefits;
import com.ayushi.claimsmicroservice.model.Claim;
import com.ayushi.claimsmicroservice.model.ProviderPolicy;
import com.ayushi.claimsmicroservice.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

/*
 * 
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimServiceImplTest1 {

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	@Mock
	private ClaimRepository claimRepoMock;

	@Mock
	private PolicyClient policyClient;

	@Mock
	private ClaimStatusDTO claimDto;

	@Mock
	private Claim claim;

	private List<ProviderPolicy> providers;

	private List<Benefits> benefits;

	@BeforeEach
	void setUp() throws Exception {
		claim = new Claim();
		claim.setClaimId(2);
		claim.setClaimStatus("Pending Action");
		claim.setDescription("claim has been submitted! Please check after few days for confirmation");
		claim.setPolicyId(1);
		claim.setBenefitId(202);
		claim.setMemberId(1);
		claim.setProviderId(1);
		claim.setAmountClaimed(60000.0);
		claim.setAmountSettled(60000.0);

		// claimDto = new ClaimStatusDTO();
		claimDto.setClaimStatus("Pending Action");
		claimDto.setDescription("claim has been submitted! Please check after few days for confirmation");
	}

	@Test
	void claimServiceImplNotNullTest() {
		assertNotNull(claimServiceImpl);
	}

	@Test
	void testGetClaimStatus_negative() throws ProviderNotFoundException {
		when(claimRepoMock.getById(2)).thenReturn(claim);
		ProviderNotFoundException thrown = Assertions.assertThrows(ProviderNotFoundException.class,
				() -> claimServiceImpl.getClaimStatus(2, 1, 3));

		assertEquals("provider not found", thrown.getMessage());

	}

}
