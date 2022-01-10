package com.ayushi.policymicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a model class used for object of type Policy
 * 
 */

@Entity
@Table(name="policy")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Policy {
		
		@Id
		private int policyId;
		private int policyNumber;
		private int benefitId;
		private double premium;
		private int tenure;
		private double capAmountBenefits;
}
