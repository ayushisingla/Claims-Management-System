package com.ayushi.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="provider_policy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderPolicy {
	
	@Id
	@JsonProperty
	public int providerId;
	@JsonProperty
	public String providerName;
	@JsonProperty
	public String providerAddress;
	@JsonProperty
	public int policyId;
	@JsonProperty
	public String location;
}
