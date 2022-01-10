package com.ayushi.membermicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ayushi.membermicroservice.dto.ClaimStatusDTO;

/**
 * 
 *
 * This class communicates with claimsMicroservice to verify the token. using
 * Feign client With provided URL and name of microservice it interact with that
 * microservice.
 *
 */
@Component
@FeignClient(name = "claims-microservice", url = "http://localhost:8090/claims")
public interface ClaimsClient {

	@GetMapping("/getClaimStatus/{claimId}/{policyId}/{memberId}")
	public ResponseEntity<ClaimStatusDTO> getClaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId, @RequestHeader(name = "Authorization", required = true) String token);

	@PostMapping("/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<ClaimStatusDTO> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount,
			@RequestHeader(name = "Authorization", required = true) String token);

}
