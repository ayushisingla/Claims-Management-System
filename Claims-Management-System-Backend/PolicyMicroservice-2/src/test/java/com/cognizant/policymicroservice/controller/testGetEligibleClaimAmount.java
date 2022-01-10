package com.ayushi.policymicroservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.policymicroservice.client.AuthClient;
import com.ayushi.policymicroservice.model.AuthenticationResponse;
import com.ayushi.policymicroservice.model.MemberPolicy;
import com.ayushi.policymicroservice.repository.MemberPolicyRepo;

/*
 * test case for getEligibleClaimAmount in policyMicroserviceController class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class TestGetEligibleClaimAmount {
	@InjectMocks
	PolicyMicroserviceContoller controllerMock;
	
	@Mock
	MemberPolicy memberPolicy;

	@Mock
	private MemberPolicyRepo memberRepoMock;
	@Mock
	private AuthClient authClientMock;
	
	/*
	 * test for getEligibleClaimAmount
	 */
	@Test
	void getEligibleClaimAmount_test() {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClientMock.getValidity("token")).thenReturn(response);
		when(memberRepoMock.findCapAmount(1,1,1)).thenReturn(memberPolicy);

		assertEquals(HttpStatus.OK, controllerMock.getEligibleClaimAmount(1,1,1,"token").getStatusCode());
	}

}
