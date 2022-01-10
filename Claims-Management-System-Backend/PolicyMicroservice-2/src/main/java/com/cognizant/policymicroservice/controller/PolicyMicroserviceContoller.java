package com.ayushi.policymicroservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.ayushi.policymicroservice.client.AuthClient;
import com.ayushi.policymicroservice.model.MemberPolicy;
import com.ayushi.policymicroservice.model.ProviderPolicy;
import com.ayushi.policymicroservice.repository.MemberPolicyRepo;
import com.ayushi.policymicroservice.repository.ProviderPolicyRepo;
import com.ayushi.policymicroservice.service.GetEligibleBenefitsService;

import feign.FeignException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/* Policy-Microservice Controller for getting claim providers, eligible claim amount and eligible benefits */

@RestController
@Api(value = "Policy Microservice Controller")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyMicroserviceContoller {

	@Autowired
	ProviderPolicyRepo providerPolicyRepo;

	@Autowired
	MemberPolicyRepo memberPolicyRepo;

	@Autowired
	AuthClient authClient;
	
	@Autowired
	GetEligibleBenefitsService getEligibleBenefitsService;
	
	// To check Token Validity just passing a message as string variable
	String tokenValidity="Token is either expired or invalid...";

	@ApiOperation(value = "Add New Providers")
	@PostMapping("/saveProvider")
	public ProviderPolicy setProviderPolicy(@RequestBody ProviderPolicy provider) {
		return providerPolicyRepo.save(provider);
	}

	/*
	 * This method validate token first by invoking authorizationservice
	 * 
	 * After that it returns the list of providers
	 */

	@ApiOperation(value = "List of providers which accepts the claim for particular policy")
	@GetMapping("/getChainOfProviders/{policyId}")
	public ResponseEntity<?> getChainOfProviders(@PathVariable("policyId") int policyId,
			@RequestHeader(name = "Authorization", required = true) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);

		}
		List<ProviderPolicy> providers = providerPolicyRepo.findAllByPolicyIdOrderByLocation(policyId);
		return new ResponseEntity<>(providers, HttpStatus.OK);
	}

	/*
	 * This method also validate token first by invoking authorizationservice
	 * 
	 * After that it returns the list of EligibleBenefits
	 */

	@ApiOperation(value = "List of benefits which can be availed under a particular policy")
	@GetMapping("/getEligibleBenefits/{policyId}/{memberId}")
	public ResponseEntity<?> getEligibleBenefits(@PathVariable("policyId") int policyId,
			@PathVariable("memberId") int memberId,
			@RequestHeader(name = "Authorization", required = true) String token) {

		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);

		}
		return new ResponseEntity<>(getEligibleBenefitsService.calculateEligibleBenefits(policyId, memberId), HttpStatus.OK);

	}


	/*
	 * This method also validate token first by invoking authorizationservice
	 * 
	 * After that it returns the amount that a member can claim
	 */

	@ApiOperation(value = "Eligible claim amount that a member can claim")
	@GetMapping("/getClaimAmount/{policyId}/{memberId}/{benefitId}")
	public ResponseEntity<?> getEligibleClaimAmount(@PathVariable int policyId, @PathVariable int memberId,
			@PathVariable int benefitId, @RequestHeader(name = "Authorization", required = true) String token) {
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>(tokenValidity, HttpStatus.FORBIDDEN);

		}
		MemberPolicy mempolicy = memberPolicyRepo.findCapAmount(policyId, memberId, benefitId);
		return new ResponseEntity<Double>(mempolicy.getCapAmountBenefits(), HttpStatus.OK);
	}

}
