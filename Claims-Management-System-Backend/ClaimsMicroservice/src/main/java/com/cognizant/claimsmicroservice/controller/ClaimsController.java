package com.ayushi.claimsmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.claimsmicroservice.client.AuthClient;
import com.ayushi.claimsmicroservice.dto.ClaimStatusDTO;
import com.ayushi.claimsmicroservice.exception.BenefitsNotFoundException;
import com.ayushi.claimsmicroservice.exception.ProviderNotFoundException;
import com.ayushi.claimsmicroservice.service.ClaimService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/* This Rest controller contain operations of getting and submitting claim Status */

@Slf4j
@Api(value = "Claims Controller")
@CrossOrigin(origins = "*")
@RestController
public class ClaimsController {

	@Autowired
	ClaimService claimserviceImpl;

	@Autowired
	AuthClient authClient;

	@Autowired
	ClaimStatusDTO claimsDto;

	// To check token Validty passing message as String
	String tokenValidity = "Token is either expired or invalid...";

	/*
	 * This method validate token first by invoking authorizationservice
	 * then invokes the claimServiceImpl
	 * After that it returns the claim status
	 */

	@ApiOperation(value = "Get Claim Status")
	@GetMapping(value = "/getClaimStatus/{claimId}/{policyId}/{memberId}", produces = "application/json")
	public ResponseEntity<?> getClaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId, @RequestHeader(name = "Authorization", required = true) String token)
			throws ProviderNotFoundException {
		log.debug("token={}", token);

		if (!authClient.getValidity(token).getValid()) {

			return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<ClaimStatusDTO>(claimserviceImpl.getClaimStatus(claimId, policyId, memberId),
				HttpStatus.OK);
	}

	
	/*
	 * this method invokes authorizationMicroservice to check the validity of token
	 * first then invokes the claimServiceImpl which invokes policyMicroservice to
	 * get List of provider , benefits and get the claim amount.
	*/
	
	@ApiOperation(value = "Submit Claim")
	@PostMapping(value = "/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}", produces = "application/json")
	public ResponseEntity<?> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount,
			@RequestHeader(name = "Authorization", required = true) String token)
			throws ProviderNotFoundException, BenefitsNotFoundException {

		if (!authClient.getValidity(token).getValid()) {

			return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);
		}

		claimsDto = claimserviceImpl.processSubmitClaim(policyId, claimId, memberId, providerId, benefitId, totalAmount,
				claimedAmount, token);
		System.out.println(claimsDto);
		log.debug("claimsDTO={}", claimsDto);
		return new ResponseEntity<ClaimStatusDTO>(claimsDto, HttpStatus.OK);
	}

}
