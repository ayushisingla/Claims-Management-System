package com.ayushi.membermicroservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.membermicroservice.dto.ClaimStatusDTO;
import com.ayushi.membermicroservice.dto.ViewBillsDTO;
import com.ayushi.membermicroservice.exception.FileNotFoundException;
import com.ayushi.membermicroservice.model.MemberClaim;
import com.ayushi.membermicroservice.model.MemberPremium;
import com.ayushi.membermicroservice.repository.ClaimRepository;
import com.ayushi.membermicroservice.repository.PremiumRepository;

/**
 * This class contains junit test cases for the ClaimServiceImpl class.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimServiceImplTest {

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	private MemberClaim memberClaim;

	private MemberPremium memberPremium;

	private ViewBillsDTO viewBillsDto;

	private ClaimStatusDTO claimDto;

	@Mock
	private PremiumRepository premiumRepository;

	@Mock
	private ClaimRepository claimRepository;

	@Test
	void repairServiceImplNotNullTest() {
		assertThat(claimServiceImpl).isNotNull();
	}

	@BeforeEach
	void setUp() throws ParseException {

		memberClaim = new MemberClaim();
		memberClaim.setClaimId(2);
		memberClaim.setClaimStatus("Pending Action");
		memberClaim.setClaimDescription("memberClaim has been submitted! Please check after few days for confirmation");
		memberClaim.setPolicyId(1);
		memberClaim.setBenefitId(202);
		memberClaim.setMemberId(1);
		memberClaim.setProviderId(1);
		memberClaim.setTotalBilledAmount(60000.0);
		memberClaim.setTotalClaimedAmount(60000.0);
		claimDto = new ClaimStatusDTO();
		claimDto.setClaimStatus("Pending Action");
		claimDto.setDescription("Claim has been submitted! Please check after few days for confirmation");

		viewBillsDto = new ViewBillsDTO();
		String sDate1 = "31/12/2020";
		String sDate2 = "10/01/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		viewBillsDto.setPaidDate(date1);
		viewBillsDto.setPremium(50000.0);
		viewBillsDto.setLatePayment(false);
		viewBillsDto.setLatePaymentCharges(0.0);
		viewBillsDto.setDueDate(date2);

		memberPremium = new MemberPremium();
		memberPremium.setPaidDate(date1);
		memberPremium.setDueDate(date2);
		memberPremium.setMemberId(1);
		memberPremium.setPolicyId(1);
		memberPremium.setLatePayment(false);
		memberPremium.setLatePaymentCharges(0);
		memberPremium.setPremium(50000.0);

	}

	/**
	 * Test to check the output of viewBills method if correct parameters are provided
	 */

	@Test
	void viewBillsTestPositive() {

		when(premiumRepository.getById(1)).thenReturn(memberPremium);

		assertEquals(viewBillsDto.getPaidDate(), memberPremium.getPaidDate());
		assertEquals(viewBillsDto.getDueDate(), memberPremium.getDueDate());
		assertEquals(viewBillsDto.getPremium(), memberPremium.getPremium());
		assertEquals(viewBillsDto.isLatePayment(), memberPremium.isLatePayment());
		assertEquals(viewBillsDto.getLatePaymentCharges(), memberPremium.getLatePaymentCharges());

	}

	/**
	 * Test to check the output of viewBills method if incorrect
	 * parameters are provided and check if it throws the exception
	 */

	@Test
	void viewBillsTestNegative() throws FileNotFoundException {

		when(premiumRepository.getById(1)).thenReturn(memberPremium);
		FileNotFoundException thrown = Assertions.assertThrows(FileNotFoundException.class,
				() -> claimServiceImpl.viewBills(1, 2));
		assertEquals("Data Not Found!!!", thrown.getMessage());

	}

}
