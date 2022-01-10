package com.ayushi.claimsmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushi.claimsmicroservice.client.PolicyClient;
import com.ayushi.claimsmicroservice.dto.ClaimStatusDTO;
import com.ayushi.claimsmicroservice.exception.BenefitsNotFoundException;
import com.ayushi.claimsmicroservice.exception.ProviderNotFoundException;
import com.ayushi.claimsmicroservice.model.Benefits;
import com.ayushi.claimsmicroservice.model.Claim;
import com.ayushi.claimsmicroservice.model.ProviderPolicy;
import com.ayushi.claimsmicroservice.repository.ClaimRepository;

import lombok.extern.slf4j.Slf4j;

/*
   Service class for submitting the claim status and getting the claim status
   */

@Slf4j
@Service
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	ClaimRepository claimRepo;

	@Autowired
	ClaimStatusDTO claimDto;

	@Autowired
	PolicyClient policyClient;

	/*
	 * returns status of the claim which are already submitted
	 */
	@Override
	public ClaimStatusDTO getClaimStatus(int claimId, int policyId, int memberId) throws ProviderNotFoundException {

		Claim claim = claimRepo.getById(claimId);

		log.debug("claim status={}", claim.getClaimStatus());
		log.debug("Policy={}", claim.getPolicyId());
		log.debug("claimid={}", claim.getClaimId());
		log.debug("member={}", claim.getMemberId());

		if (claim.getPolicyId() == policyId && claim.getMemberId() == memberId) {
			claimDto.setClaimStatus(claim.getClaimStatus());
			claimDto.setDescription(claim.getDescription());
			log.debug("claimdto={}", claimDto.getClaimStatus());
		} else {
			throw new ProviderNotFoundException("provider not found");
		}

		return claimDto;

	}

	/*
	 * submit the new claim if 3 conditions are true: 1. If the Claimed Amount is
	 * applicable under the subscribed policy 2. If the Claimed benefit is
	 * applicable under the subscribed policy 3. If the Hospital in which benefits
	 * are availed is a permissible Health Care Provider (Hospital).
	 * 
	 * Claims Microservice will invoke the Policy Microservice for retrieving the
	 * permissible Provider Details (Hospital), eligible benefits of a policy and
	 * the eligible claim amount for the benefits. Based on the details retrieved,
	 * the Claims Microservice will decide on any of the following actions:
	 * sanctioning / rejecting / raising a dispute
	 * 
	 */
	@Override
	public ClaimStatusDTO processSubmitClaim(int policyId, int claimId, int memberId, int providerId, int benefitId,
			double totalAmount, double claimedAmount, String token)
			throws ProviderNotFoundException, BenefitsNotFoundException {
		Claim claimObj = null;
		List<ProviderPolicy> chainOfProviders = policyClient.getChainOfProviders(policyId, token);
		log.debug("chainOfProvider={}", chainOfProviders);
		List<Benefits> eligibleBenefits = policyClient.getEligibleBenefits(policyId, memberId, token);
		double eligibleClaimAmount = policyClient.getClaimAmount(policyId, memberId, benefitId, token);
		log.debug("claim Amount={}", eligibleClaimAmount);

		if (claimedAmount <= eligibleClaimAmount) {

			if (claimedAmount > totalAmount) {
				claimObj = new Claim(claimId, "Under Dispute",
						"Claim Amount cannot be settled more than its actually required!", policyId, memberId,
						benefitId, providerId, claimedAmount, 0);
				claimRepo.save(claimObj);
				claimDto.setClaimStatus(claimObj.getClaimStatus());
				claimDto.setDescription(claimObj.getDescription());
			} else {

				ProviderPolicy providers = chainOfProviders.stream().filter(p -> p.getProviderId() == providerId)
						.findFirst().orElseThrow(() -> new ProviderNotFoundException("provider not found"));

				Benefits benefits = eligibleBenefits.stream().filter(b -> b.getBenefitId() == benefitId).findFirst()
						.orElseThrow(() -> new BenefitsNotFoundException("benefit not found"));

				claimObj = new Claim(claimId, "Pending Action",
						"claim has been submitted! Please check after few days for confirmation", policyId, memberId,
						benefitId, providerId, claimedAmount, claimedAmount);
				claimRepo.save(claimObj);
				claimDto.setClaimStatus(claimObj.getClaimStatus());
				claimDto.setDescription(claimObj.getDescription());

			}

		} else {
			claimObj = new Claim(claimId, "Claim Rejected", "Claim Amount is greater than the eligible claim Amount",
					policyId, memberId, benefitId, providerId, claimedAmount, 0);
			claimRepo.save(claimObj);
			claimDto.setClaimStatus(claimObj.getClaimStatus());
			claimDto.setDescription(claimObj.getDescription());
		}

		return claimDto;
	}

}
