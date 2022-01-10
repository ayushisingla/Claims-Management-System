package com.ayushi.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a model class which we will be storing claim details of member in the
 * database..
 * 
 */

@Entity
@Table(name = "member_claim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MemberClaim {

	@Id
	/**
	 * This will be the id of the claim.
	 * 
	 */
	private int claimId;
	/**
	 * This will be the id of the policy.
	 * 
	 */
	private int policyId;
	/**
	 * This will be the id of the member.
	 * 
	 */
	private int memberId;
	/**
	 * This will be the id of the provider.
	 * 
	 */
	private int providerId;
	/**
	 * This will be the id of the benefit.
	 * 
	 */
	private int benefitId;
	/**
	 * This will be the total billed amount.
	 * 
	 */
	private double totalBilledAmount;
	/**
	 * This will be the total claimed amount.
	 * 
	 */
	private double totalClaimedAmount;
	/**
	 * This will be the status of the claim.
	 * 
	 */
	private String claimStatus;
	/**
	 * This will be the description of the claim.
	 * 
	 */
	private String claimDescription;
}
