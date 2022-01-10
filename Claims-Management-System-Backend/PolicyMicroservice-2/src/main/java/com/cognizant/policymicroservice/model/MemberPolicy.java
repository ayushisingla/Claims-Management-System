package com.ayushi.policymicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a model class used for object of type MemberPolicy
 * 
 */

@Entity
@Table(name = "member_policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberPolicy {

	@Id
	private int memberId;
	private int policyId;
	private int policyNumber;
	private int benefitId;
	private Date subscriptionDate;
	private int tenure;
	private double capAmountBenefits;
}
