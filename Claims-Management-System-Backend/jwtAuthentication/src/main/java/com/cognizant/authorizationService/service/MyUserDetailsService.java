package com.ayushi.authorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ayushi.authorizationService.Repository.UserRepository;
import com.ayushi.authorizationService.model.MyUser;

/**
 * This class validates the  username and returns the username and password from the UserRepository
 */ 

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	 /**
	 * @param username
	 * Returns username and password if the username validation is successful
	 * If not valid then throws UsernameNotFoundException 
	 */ 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser cusUser =  userRepository.findByUsername(username);
		return new User(cusUser.getUsername(),cusUser.getPassword(),new ArrayList<>());
	}


}
