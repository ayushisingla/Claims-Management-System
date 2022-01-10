package com.ayushi.claimsmicroservice;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClaimsMicroserviceApplicationTests {

	@Test
	void contextLoads() {
		ClaimsMicroserviceApplication.main(new String[] {});
		assertTrue(true);
	}

}
