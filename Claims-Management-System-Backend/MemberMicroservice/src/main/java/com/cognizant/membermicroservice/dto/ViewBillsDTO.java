package com.ayushi.membermicroservice.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** DTO for sending the sending the details of a bill. */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ViewBillsDTO {

	private Date paidDate;
	private double premium;
	private boolean latePayment;
	private double latePaymentCharges;
	private Date dueDate;
}
