package com.ayushi.membermicroservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This is a model class which we will be storing member details in the
 * database..
 * 
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Member {
	@Id
	/**
	 * This will be the id of a member.
	 */
	private int memberId;
	/**
	 * This will be the name of a member.
	 */
	private String memberName;
	/**
	 * This will be the phone number of a member.
	 */
	private String phoneNumber;
	/**
	 * This will be the salary of a member.
	 */
	private int salary;
	/**
	 * This will be the gender of a member.
	 */
	private String gender;
}
