package com.ayushi.membermicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is a model class which we will be storing details of premium of the
 * member in the database..
 * 
 */

@Entity
@Table(name = "member_premium")
@Getter
@Setter
@NoArgsConstructor
@Component
public class MemberPremium {

	@Id
	/**
	 * This will be id of the member.
	 * 
	 */
	private int memberId;
	/**
	 * This will be id of the policy.
	 * 
	 */
	private int policyId;
	/**
	 * This will be the date on which premium of the policy has been paid.
	 * 
	 */
	private Date paidDate;
	/**
	 * This will be the due date of premium of the policy.
	 * 
	 */
	private Date dueDate;
	/**
	 * This will be the amount of premium the member has to pay.
	 * 
	 */
	private double premium;
	/**
	 * This will be the boolean value for the late payment (true or false).
	 * 
	 */
	private boolean latePayment;
	/**
	 * This will be the late payment charges if the member pays the premium after
	 * the due date.
	 * 
	 */
	private double latePaymentCharges;

}
