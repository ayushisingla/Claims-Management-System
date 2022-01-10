package com.ayushi.authorizationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayushi.authorizationService.model.MyUser;

/**
 * This is the user repository to fetch the userdetails
 */ 
public interface UserRepository extends JpaRepository<MyUser,String > {
	
	/**
	 * @param username
	 * returns userdetails by username from database
	 */ 
	public MyUser findByUsername(String username);

	

}
