package com.ayushi.claimsmicroservice.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DTO for sending the status and description of a claim to member microservice

@NoArgsConstructor
@Getter
@Setter
@Component
@AllArgsConstructor
public class ClaimStatusDTO {

	@JsonProperty
	private String claimStatus;
	@JsonProperty
	private String description;

}
