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
 * This class contains junit test cases for the Member model class 
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

	@Mock
	private Member mem;

	/**
	 * 
	 * To Test Member is not null
	 */

	@Test
	@DisplayName("Checking whether Member class is loading or not.")
	void memberIsLoadedOrNot() {
		assertThat(mem).isNotNull();
	}

	/**
	 * 
	 * To Test Member constructor
	 */

	@DisplayName("Checking whether Member class is responding correctly or not.")
	@Test
	void testingMember() {

		mem = new Member(1, "Shivranjan", "912312312", 10000, "Male");
		mem.setMemberId(3);
		mem.setMemberName("Riteesh");
		mem.setPhoneNumber("8232323562");
		mem.setSalary(25000);
		mem.setGender("Male");

		assertEquals(3, mem.getMemberId());
		assertEquals("Riteesh", mem.getMemberName());
		assertEquals("8232323562", mem.getPhoneNumber());
		assertEquals(25000, mem.getSalary());
		assertEquals("Male", mem.getGender());

	}
}
