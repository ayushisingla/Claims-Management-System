package com.ayushi.policymicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for MemberPolicy class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class MemberPolicyTest {

	@Mock
	public MemberPolicy memberPolicy;

	/*
	 * tests the MemberPolicy class is loading or not
	 */
	@Test
	@DisplayName("Checking if MemberPolicy is loading or not.")
	void  memberPolicyIsLoaded() {
		assertThat(memberPolicy).isNotNull();
	}

	/*
	 * test if the MemberPolicy class is working properly
	 */
	@Test
	@DisplayName("Checking if MemberPolicy class is working properly")
	void Test() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		memberPolicy.setMemberId(1);
		memberPolicy.setPolicyId(1);
		memberPolicy.setPolicyNumber(101);
		memberPolicy.setBenefitId(202);
		memberPolicy.setSubscriptionDate(date);
		memberPolicy.setTenure(21);
		memberPolicy.setCapAmountBenefits(100000.00);
		memberPolicy = new MemberPolicy(1, 1, 101, 201, date, 21, 100000.00);
		assertEquals(1, memberPolicy.getMemberId());
		assertEquals(1, memberPolicy.getPolicyId());
		assertEquals(101, memberPolicy.getPolicyNumber());
		assertEquals(201, memberPolicy.getBenefitId());
		assertEquals(date, memberPolicy.getSubscriptionDate());
		assertEquals(21, memberPolicy.getTenure());

	}

	/*
	 * tests the MemberPolicy class NoArgsConstructor
	 */
	@Test
	void noArgsConstructor() {
		MemberPolicy memberPolicy = new MemberPolicy();
		assertEquals(memberPolicy, memberPolicy);
	}

	/*
	 * tests the MemberPolicy class AllArgsConstructor
	 */
	@Test
	void allArgsConstructor() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		MemberPolicy memPolicy = new MemberPolicy(1, 1, 101, 201, date, 21, 100000.00);
		assertEquals(memPolicy.getBenefitId(), memberPolicy.getBenefitId());
		assertEquals(memPolicy.getCapAmountBenefits(), memberPolicy.getCapAmountBenefits());
		assertEquals(memPolicy.getMemberId(), memberPolicy.getMemberId());
		assertEquals(memPolicy.getPolicyId(), memberPolicy.getPolicyId());
		assertEquals(memPolicy.getPolicyNumber(), memberPolicy.getPolicyNumber());
		assertEquals(memPolicy.getSubscriptionDate(), memberPolicy.getSubscriptionDate());
		assertEquals(memPolicy.getTenure(), memberPolicy.getTenure());
	}

	@BeforeEach
	void setUp() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		memberPolicy = new MemberPolicy();
		memberPolicy.setMemberId(1);
		memberPolicy.setPolicyId(1);
		memberPolicy.setPolicyNumber(101);
		memberPolicy.setBenefitId(202);
		memberPolicy.setSubscriptionDate(date);
		memberPolicy.setTenure(21);
		memberPolicy.setCapAmountBenefits(100000.00);
		memberPolicy = new MemberPolicy(1, 1, 101, 201, date, 21, 100000.00);
	}
}
