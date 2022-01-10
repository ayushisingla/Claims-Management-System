package com.ayushi.claimsmicroservice.service;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimServiceTest {
	
	@Mock
	ClaimService service;
	
	@Test
	@DisplayName("Checking for ClaimService - if it is loading or not for @GetMapping")
	 void claimServiceImplNotNullTest() {
		assertThat(service).isNotNull();
	}
}