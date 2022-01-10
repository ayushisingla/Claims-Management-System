package com.ayushi.membermicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This is a model class which we will be storing MemberPolicy details in the
 * database..
 * 
 */

@Getter
@Setter
@AllArgsConstructor
public class MemberPolicy {

	/**
	 * This will be id of the member.
	 * 
	 */
	private int memberId;
	/**
	 * This will be name of the member.
	 * 
	 */
	private String memberName;
	/**
	 * This will be id of the policy.
	 * 
	 */
	private int policyId;
	/**
	 * This will be date of subscription on which the member subscribed to the
	 * policy.
	 * 
	 */
	private String subscriptionDate;
	/**
	 * This will be id of the location.
	 * 
	 */
	private int locationId;
	/**
	 * This will be name of the location.
	 * 
	 */
	private String locationName;
	/**
	 * This will be id of the provider.
	 * 
	 */
	private int providerId;
	/**
	 * This will be name of the provider.
	 * 
	 */
	private String providerName;
}
