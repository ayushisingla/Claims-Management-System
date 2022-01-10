package com.ayushi.authorizationService.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.ayushi.authorizationService.model.AuthenticationRequest;
import com.ayushi.authorizationService.service.JwtUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtRequestFilterTest {

	private static final String token = "260bce87-6be9-4897-add7-b3b675952538";
	private static final String testUri = "/testUri";

	@Mock
	private JwtUtil jwtUtil;

	@InjectMocks
	private JwtRequestFilter jwtRequestFilter = new JwtRequestFilter();

	@Test
	public void testDoFilterInternalPositiveScenarioWhenTokenIsInHeader() throws ServletException, IOException {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("admin1", "admin1");
		MockHttpServletRequest request = new MockHttpServletRequest();
		UserDetails userDetails = new User(authenticationRequest.getUsername(), authenticationRequest.getPassword(),
				new ArrayList<>());
		request.addHeader(token, token);
		request.setRequestURI(testUri);
		MockHttpServletResponse response = new MockHttpServletResponse();
		MockFilterChain filterChain = new MockFilterChain();
		when(jwtUtil.generateToken(userDetails)).thenReturn(testUri);
		jwtRequestFilter.doFilterInternal(request, response, filterChain);
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
}
