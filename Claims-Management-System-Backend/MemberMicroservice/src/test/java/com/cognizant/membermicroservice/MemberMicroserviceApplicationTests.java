package com.ayushi.membermicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * Test class for MemberMicroserviceApplication
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class MemberMicroserviceApplicationTests {
	@Mock
	MemberMicroserviceApplication memberMicroserviceApplication;

	@Test
	void contextLoads() {

		assertNotNull(memberMicroserviceApplication);
	}
}
