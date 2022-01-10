package com.ayushi.membermicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains junit test cases for the MemberPremium model class 
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPremiumTest {

	@Mock
	private MemberPremium premium;

	/**
	 * 
	 * To Test MemberPremium is not null
	 */

	@Test
	@DisplayName("Checking whether MemberPolicy class is loading or not.")
	void memberPremiumIsLoadedOrNot() {
		assertThat(premium).isNotNull();
	}

	/**
	 * 
	 * To Test MemberPremium constructor
	 */

	@DisplayName("Checking whether MemberPolicy class is responding correctly or not.")
	@Test
	void testingMemberPremium() throws ParseException {
		String sDate1 = "31/12/2020";
		String sDate2 = "10/01/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		premium = new MemberPremium();
		premium.setMemberId(3);
		premium.setPolicyId(2);
		premium.setPaidDate(date1);
		premium.setDueDate(date2);
		premium.setPremium(9000);
		premium.setLatePaymentCharges(0);
		premium.setLatePayment(false);

		assertEquals(3, premium.getMemberId());
		assertEquals(2, premium.getPolicyId());
		assertEquals(date1, premium.getPaidDate());
		assertEquals(date2, premium.getDueDate());
		assertEquals(9000, premium.getPremium());
		assertEquals(0, premium.getLatePaymentCharges());
		assertEquals(false, premium.isLatePayment());

	}
}
