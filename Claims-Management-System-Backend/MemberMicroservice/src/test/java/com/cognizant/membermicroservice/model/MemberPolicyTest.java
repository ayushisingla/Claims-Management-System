package com.ayushi.membermicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains junit test cases for the MemberPolicy model class 
 * 
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPolicyTest {

	@Mock
	private MemberPolicy mempolicy;

	/**
	 * 
	 * To Test MemberPolicy is not null
	 */

	@Test
	@DisplayName("Checking whether MemberPolicy class is loading or not.")
	void memberPolicyIsLoadedOrNot() {
		assertThat(mempolicy).isNotNull();
	}

	/**
	 * 
	 * To Test MemberPolicy Constructor
	 */

	@DisplayName("Checking whether MemberPolicy class is responding correctly or not.")
	@Test
	void testingMemberPolicy() {
		mempolicy = new MemberPolicy(1, "Riteesh", 3, "2021-06-01", 9, "Hyderabad", 4, "LIC");
		mempolicy.setMemberId(3);
		mempolicy.setMemberName("Riteesh");
		mempolicy.setPolicyId(2);
		mempolicy.setSubscriptionDate("2020-05-23");
		mempolicy.setLocationId(3);
		mempolicy.setLocationName("Mumbai");
		mempolicy.setProviderId(5);
		mempolicy.setProviderName("ICICI");

		assertEquals(3, mempolicy.getMemberId());
		assertEquals("Riteesh", mempolicy.getMemberName());
		assertEquals(2, mempolicy.getPolicyId());
		assertEquals("2020-05-23", mempolicy.getSubscriptionDate());
		assertEquals(3, mempolicy.getLocationId());
		assertEquals("Mumbai", mempolicy.getLocationName());
		assertEquals(5, mempolicy.getProviderId());
		assertEquals("ICICI", mempolicy.getProviderName());

	}
}
