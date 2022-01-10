package com.ayushi.claimsmicroservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ayushi.claimsmicroservice.client.AuthClient;
import com.ayushi.claimsmicroservice.dto.ClaimStatusDTO;
import com.ayushi.claimsmicroservice.exception.BenefitsNotFoundException;
import com.ayushi.claimsmicroservice.exception.ProviderNotFoundException;
import com.ayushi.claimsmicroservice.model.AuthenticationResponse;
import com.ayushi.claimsmicroservice.service.ClaimService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ClaimsControllerTest {

	@Autowired
	private MockMvc mvc;

	@Mock
	AuthClient authClientMock;

	@Mock
	ClaimService claimserviceImpl;

	@Mock
	ClaimStatusDTO claimsStatusDto;

	@InjectMocks
	ClaimsController claimsControllerMock;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testgetClaimStatus_positive() throws Exception {

		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);

		MvcResult result = mvc.perform(get("/getClaimStatus/{claimId}/{policyId}/{memberId}", 1, 1, 2)).andReturn();

		when(claimserviceImpl.getClaimStatus(1, 1, 2)).thenReturn(claimsStatusDto);

		ResponseEntity<?> rs = claimsControllerMock.getClaimStatus(1, 1, 2, "token");

		assertEquals(HttpStatus.OK, rs.getStatusCode());
		 assertEquals(claimsStatusDto.toString(),claimsControllerMock.getClaimStatus(1,
		 1, 2, "token").getBody().toString());

	}

	@Test
	void testSubmitClaim_positive() throws ProviderNotFoundException, BenefitsNotFoundException {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);
		claimsStatusDto.setClaimStatus("Pending Action");
		claimsStatusDto.setDescription("claim has been submitted! Please check after few days for confirmation");
		when(claimserviceImpl.processSubmitClaim(1, 2, 1, 1, 202, 60000.0, 60000.0, "token"))
				.thenReturn(claimsStatusDto);

		assertEquals(claimsStatusDto,
				claimsControllerMock.submitClaim(1, 2, 1, 1, 202, 60000.0, 60000.0, "token").getBody());
		assertEquals(HttpStatus.OK,
				claimsControllerMock.submitClaim(1, 2, 1, 1, 202, 60000.0, 60000.0, "token").getStatusCode());

	}

	@Test
	void testSubmitClaim_negative() throws ProviderNotFoundException, BenefitsNotFoundException {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);
		claimsStatusDto.setClaimStatus("Pending Action");
		claimsStatusDto.setDescription("claim has been submitted! Please check after few days for confirmation");
		when(claimserviceImpl.processSubmitClaim(1, 2, 1, 1, 202, 60000.0, 60000.0, "token"))
				.thenReturn(claimsStatusDto);

		assertFalse(claimsStatusDto
				.equals(claimsControllerMock.submitClaim(1, 2, 1, 1, 203, 60000.0, 60000.0, "token").getBody()));

	}
	
	@Test
	void testGetClaimStatus_invalidToken() throws Exception {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);
		when(authClientMock.getValidity("wrongtoken")).thenReturn(new AuthenticationResponse("wrongtoken", false));
		

		MvcResult resultGetStatus = mvc.perform(get("/getClaimStatus/{claimId}/{policyId}/{memberId}", 1, 1, 2)).andReturn();

		when(claimserviceImpl.getClaimStatus(1, 1, 2)).thenReturn(claimsStatusDto);

		ResponseEntity<?> rs = claimsControllerMock.getClaimStatus(1, 1, 2, "wrongtoken");

		assertEquals(HttpStatus.FORBIDDEN, rs.getStatusCode());

	}
	
	@Test
	void testSubmitClaim_invalidToken() throws Exception {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);
		when(authClientMock.getValidity("wrongtoken")).thenReturn(new AuthenticationResponse("wrongtoken", false));
		

		MvcResult resultGetStatus = mvc.perform(get("/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}",1, 2, 1, 1, 202, 60000.0, 60000.0)).andReturn();

		when(claimserviceImpl.getClaimStatus(1, 1, 2)).thenReturn(claimsStatusDto);

		ResponseEntity<?> rs = claimsControllerMock.submitClaim(1, 2, 1, 1, 203, 60000.0, 60000.0, "wrongtoken");

		assertEquals(HttpStatus.FORBIDDEN, rs.getStatusCode());

	}
	
	
	
	
	
	
	
	

}
