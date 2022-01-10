package com.ayushi.authorizationService.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.authorizationService.service.JwtUtil;

@SpringBootTest(classes = JwtUtil.class)
@RunWith(SpringRunner.class)
class JwtUtilTest {

	UserDetails userDetails;

	@Autowired
	JwtUtil jwtUtil;

	@Test
	void genrateTokenTest() {
		userDetails = new User("advsdvdmin", "advsdvdmin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		assertNotNull(generateToken);
	}

	@Test
	void validateTokenTest() {
		userDetails = new User("dvsdvmin", "adcadcmin", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(generateToken);
		assertEquals(true, validateToken);
	}

}
