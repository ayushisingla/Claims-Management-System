package com.ayushi.membermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ayushi.membermicroservice.client.AuthClient;
import com.ayushi.membermicroservice.client.ClaimsClient;
import com.ayushi.membermicroservice.dto.ClaimStatusDTO;
import com.ayushi.membermicroservice.dto.ViewBillsDTO;
import com.ayushi.membermicroservice.service.ClaimService;

import feign.FeignException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for MemberMicroservice. This
 * controller has mappings as- getmapping-viewBills()
 * getmapping-getClaimStatus() 
 * postmapping-submitClaim()
 *
 */

@Slf4j
@Api(value = "Member Premium Controller")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MemberPremiumController {
	
   @Autowired
	public ClaimService claimserviceimpl;
    
    @Autowired
	public AuthClient authClient;
    
    @Autowired
	public ClaimsClient claimsClient;

	/**
	 * 
	 * @param token    - used to verify the token with jwtAuthentication
	 *                 microservice
	 * @param memberId - used to find the member of particular memberId
	 * @param policyId - used to find the policy of the particular member
	 * @return ResponseEntity<Response>
	 * 
	 *         returns the details of the members having the particular memberId and
	 *         policyId.
	 *
	 */

	@GetMapping(value = "/viewBills/{memberId}/{policyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> viewBills(@PathVariable Integer memberId, @PathVariable Integer policyId,
			@RequestHeader(name = "Authorization", required = true) String token) {
		log.info("Start - viewBills()");
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.FORBIDDEN);

		}
		log.info("End - viewBills()");
		return new ResponseEntity<ViewBillsDTO>(claimserviceimpl.viewBills(memberId, policyId), HttpStatus.OK);
	}

	/**
	 * 
	 * @param token    - used to verify the token with jwtAuthentication
	 *                 microservice
	 * @param claimId  - used to get the claim of the particular claimId
	 * @param policyId - used to find the policy of the particular member
	 * @param memberId - used to find the member of particular memberId
	 * @return ResponseEntity<Response> - returns the status of the claim from the
	 *         claimId, policyId and memberId.
	 *
	 */

	@GetMapping(value = "/getClaimStatus/{claimId}/{policyId}/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getClaimStatus(@PathVariable int claimId, @PathVariable int policyId,
			@PathVariable int memberId, @RequestHeader(name = "Authorization", required = true) String token) {
		log.info("Start - getClaimStatus()");
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.BAD_REQUEST);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.BAD_REQUEST);

		}

		ResponseEntity<ClaimStatusDTO> claimStatus = claimsClient.getClaimStatus(claimId, policyId, memberId, token);
		log.info("End - getClaimStatus()");
		return claimStatus;

	}

	/**
	 * 
	 * @param token         - used to verify the token with jwtAuthentication
	 *                      microservice
	 * @param policyId      - used to set the policyId of the particular member
	 * @param claimId       - used to set the claimId of the particular claim
	 * @param memberId      - used to find the member of particular memberId
	 * @param providerId    - used to set the providerId who is providing the policy
	 * @param benefitId     - used to set the id of the benefit which comes under
	 *                      the particular policy
	 * @param totalAmount   - used to set the total amount for the claim
	 * @param claimedAmount - used to set the amount that can be claimed
	 * @return ResponseEntity<Response> - returns the status of the claim and its
	 *         description after submitting the claim.
	 *
	 */

	@PostMapping("/submitClaim/{policyId}/{claimId}/{memberId}/{providerId}/{benefitId}/{totalAmount}/{claimedAmount}")
	public ResponseEntity<?> submitClaim(@PathVariable int policyId, @PathVariable int claimId,
			@PathVariable int memberId, @PathVariable int providerId, @PathVariable int benefitId,
			@PathVariable double totalAmount, @PathVariable double claimedAmount,
			@RequestHeader(name = "Authorization", required = true) String token) {
		log.info("Start - submitClaim()");
		try {
			if (!authClient.getValidity(token).getValid()) {

				return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.BAD_REQUEST);
			}

		} catch (FeignException e) {
			return new ResponseEntity<>("Token is either expired or invalid...", HttpStatus.BAD_REQUEST);

		}
		ResponseEntity<ClaimStatusDTO> claimResponse = claimsClient.submitClaim(policyId, claimId, memberId, providerId,
				benefitId, totalAmount, claimedAmount, token);
		log.info("End - submitClaim()");
		return claimResponse;
	}

}
