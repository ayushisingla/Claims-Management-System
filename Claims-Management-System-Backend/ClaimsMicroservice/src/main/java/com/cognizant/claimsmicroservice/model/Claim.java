package com.ayushi.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "claim")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class Claim {

	@Id
	private int claimId;
	private String claimStatus;
	private String description;
	private int policyId;
	private int memberId;
	private int benefitId;
	private int providerId;
	private double amountClaimed;
	private double amountSettled;
	
	
	
}
