package com.ayushi.membermicroservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.membermicroservice.client.AuthClient;
import com.ayushi.membermicroservice.client.ClaimsClient;
import com.ayushi.membermicroservice.dto.ClaimStatusDTO;
import com.ayushi.membermicroservice.dto.ViewBillsDTO;
import com.ayushi.membermicroservice.model.AuthenticationResponse;
import com.ayushi.membermicroservice.model.MemberClaim;
import com.ayushi.membermicroservice.model.MemberPremium;
import com.ayushi.membermicroservice.repository.ClaimRepository;
import com.ayushi.membermicroservice.repository.PremiumRepository;
import com.ayushi.membermicroservice.service.ClaimService;
import com.ayushi.membermicroservice.service.ClaimServiceImpl;

/**
 * 
 * This class contains junit test cases for the MemberPremiumController class 
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPremiumControllerTest {

	@InjectMocks
	MemberPremiumController memberController;

	@Mock
	PremiumRepository premiumRepo;

	@Mock
	ClaimRepository claimRepo;

	@Mock
	ClaimService claimserviceimpl;

	ViewBillsDTO viewdto;

	ClaimStatusDTO claimdto;

	@Mock
	AuthClient authClient;

	@Mock
	ClaimsClient claimsClient;

	@InjectMocks
	private ClaimService claimService = new ClaimServiceImpl();

	@BeforeEach
	void setUp() throws ParseException {

		viewdto = new ViewBillsDTO();
		String sDate1 = "31/12/2020";
		String sDate2 = "10/01/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		viewdto.setPaidDate(date1);
		viewdto.setPremium(50000.0);
		viewdto.setLatePayment(false);
		viewdto.setLatePaymentCharges(0.0);
		viewdto.setDueDate(date2);

		MemberPremium memberPremium = new MemberPremium();
		String sDate3 = "31/12/2020";
		String sDate4 = "10/01/2021";
		Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
		Date date4 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);
		memberPremium.setPolicyId(1);
		memberPremium.setMemberId(1);
		memberPremium.setDueDate(date3);
		memberPremium.setPaidDate(date4);
		memberPremium.setPremium(10000.0);
		memberPremium.setLatePayment(true);
		memberPremium.setLatePaymentCharges(100.0);

	}

	/**
	 * To test viewBills method
	 */

	@Test
	void viewBillsTest() throws Exception {
		AuthenticationResponse response = new AuthenticationResponse("token", true);

		when(authClient.getValidity("token")).thenReturn(response);
		when(claimserviceimpl.viewBills(1, 1)).thenReturn(viewdto);
		assertEquals(HttpStatus.OK, memberController.viewBills(1, 1, "token").getStatusCode());

	}

	/**
	 * To test getClaimStatus method
	 */

	@Test
	void getClaimStatusTest() throws Exception {

		AuthenticationResponse response = new AuthenticationResponse("token", true);

		MemberClaim memberClaim = new MemberClaim(1, 1, 1, 1, 202, 10000.0, 10000.0, "Pending Action",
				"claim has been submitted! Please check after few days for confirmation");

		ResponseEntity<ClaimStatusDTO> claims = new ResponseEntity<ClaimStatusDTO>(claimdto, HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(response);
		when(claimsClient.getClaimStatus(1, 1, 1, "token")).thenReturn(claims);
		assertEquals(claims.getStatusCodeValue(),
				memberController.getClaimStatus(1, 1, 1, "token").getStatusCodeValue());

	}

	/**
	 * To test submitClaim method
	 */

	@Test
	void submitClaimTest() throws Exception {

		AuthenticationResponse response = new AuthenticationResponse("token", true);

		MemberClaim memberClaim = new MemberClaim(1, 1, 1, 1, 202, 10000.0, 10000.0, "Pending Action",
				"claim has been submitted! Please check after few days for confirmation");
		ResponseEntity<ClaimStatusDTO> claims = new ResponseEntity<ClaimStatusDTO>(claimdto, HttpStatus.OK);

		when(authClient.getValidity("token")).thenReturn(response);
		when(claimsClient.submitClaim(1, 1, 1, 1, 201, 10000, 10000, "token")).thenReturn(claims);

		assertEquals(claims.getStatusCodeValue(),
				memberController.submitClaim(1, 1, 1, 1, 201, 10000, 10000, "token").getStatusCodeValue());
	}

}
