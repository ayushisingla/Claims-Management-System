package com.ayushi.claimsmicroservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ayushi.claimsmicroservice.dto.ClaimStatusDTO;
import com.ayushi.claimsmicroservice.exception.BenefitsNotFoundException;
import com.ayushi.claimsmicroservice.exception.ProviderNotFoundException;
//Interface for the service
@Service
@Component
public interface ClaimService {

	//For claim status Request
	
	public ClaimStatusDTO getClaimStatus(int claimId,int policyId, int memberId) throws ProviderNotFoundException;
	
	
	//For Claim Submit Request
	public ClaimStatusDTO processSubmitClaim(int policyId,
			 int claimId,
			 int memberId,
			 int providerId,
			 int benefitId,
			 double totalAmount,
			 double claimedAmount,String token)throws ProviderNotFoundException,BenefitsNotFoundException;
	
}
