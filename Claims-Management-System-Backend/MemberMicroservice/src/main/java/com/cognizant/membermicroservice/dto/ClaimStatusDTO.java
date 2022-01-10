package com.ayushi.membermicroservice.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** DTO for sending the status and description of a claim */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class ClaimStatusDTO {

	private String claimStatus;
	private String description;
}
