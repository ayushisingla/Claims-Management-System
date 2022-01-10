package com.ayushi.claimsmicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="benefits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Benefits {
	
	@Id
	@JsonProperty
	private int benefitId;
	@JsonProperty
	private String benefitName;
}
