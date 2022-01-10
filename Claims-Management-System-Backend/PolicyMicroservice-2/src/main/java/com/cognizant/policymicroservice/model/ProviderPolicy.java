package com.ayushi.policymicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a model class used for object of type ProviderPolicy
 * 
 */

@Entity
@Table(name="provider_policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProviderPolicy {
	
	@Id
	public int providerId;
	public String providerName;
	public String providerAddress;
	public int policyId;
	public String location;
}
