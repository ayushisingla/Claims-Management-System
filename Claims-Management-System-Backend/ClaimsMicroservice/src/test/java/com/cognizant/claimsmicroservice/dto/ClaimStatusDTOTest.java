package com.ayushi.claimsmicroservice.dto;

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
 * This class contains test cases for the ClaimStatusDTO class which are written
 * using junit
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimStatusDTOTest {

	@Mock
	ClaimStatusDTO claimStatusDto;

	
	/**
	 * Test the ClaimStatusDTO is not null
	 */
	@Test
    @DisplayName("Checking if ClaimStatusDTO class is loading or not.")
     void claimStatusDTOIsLoadedOrNot() {
        assertThat(claimStatusDto).isNotNull();
    }
	
	/**
	 * Checking if ClaimStatusDTO class is responding correctly or not.
	 */
	@DisplayName("Checking if ClaimStatusDTO class is responding correctly or not.")
    @Test
     void testingMember(){
    	 
    	claimStatusDto=new ClaimStatusDTO("Not Claimed","Medibuddy Claim");
    	claimStatusDto.setClaimStatus("Claimed");
    	claimStatusDto.setDescription("LIC Claim");
    	
        
        
        assertEquals("Claimed",claimStatusDto.getClaimStatus());
        assertEquals("LIC Claim",claimStatusDto.getDescription());
          
      
    }

}
