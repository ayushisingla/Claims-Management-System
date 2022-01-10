package com.ayushi.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class contains test cases for the ProviderPolicy model class which are
 * written using junit
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class ProviderPolicyTest {

	@Mock
	ProviderPolicy providerPolicy;
	/**
	 * Checking if ProviderPolicy class is loading or not.
	 */
	@Test
	@DisplayName("Checking if ProviderPolicy class is loading or not.")
	void claimIsLoadedOrNot() {
		assertThat(providerPolicy).isNotNull();
	}
	@BeforeEach
	void setUp() throws Exception {
		providerPolicy = new ProviderPolicy(1,"City Hospital","MG Road",1,"Chennai");
	}

	/**
	 * 
	 * Testing ProviderPolicy All Argument Constructor
	 */
	@Test
	public void testProviderAllArgsConstructor() {
		assertEquals(1, providerPolicy.getProviderId());
		assertEquals("Chennai", providerPolicy.getLocation());

	}

	/**
	 * 
	 * Testing Getters and setters
	 */
	@Test
	public void testGettersSetters() {

		//new ProviderPolicy(2,"Chitnis Nagar","LIC",1,"Nagpur")
		providerPolicy.setProviderId(2);
		providerPolicy.setLocation("Jalandhar");
		providerPolicy.setProviderName("Piims");
		providerPolicy.setProviderAddress("Model Town");
		providerPolicy.setPolicyId(1);

		assertEquals(2,providerPolicy.getProviderId());
		assertEquals( "Piims",providerPolicy.getProviderName());
		assertEquals( "Jalandhar",providerPolicy.getLocation());
		assertEquals( "Model Town",providerPolicy.getProviderAddress());
		assertEquals( 1,providerPolicy.getPolicyId());
		

	}

	/**
	 * 
	 * Testing ProviderPolicy toString() method
	 */
	@Test
	public void testToString() {
		log.debug("benefit={}", providerPolicy);
		String s = providerPolicy.toString();
		assertEquals(providerPolicy.toString(), s);

	}

}
