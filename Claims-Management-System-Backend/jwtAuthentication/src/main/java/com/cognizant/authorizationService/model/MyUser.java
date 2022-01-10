package com.ayushi.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the model class for MyUser
 */ 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myuser")
public class MyUser {

	@Id
	@Column(name = "memberid")
	private String memberid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	private String token;
	/**
	* All ArgsConstructor
	*/ 
	public MyUser(String memberid, String username, String password) {
		super();
		this.memberid = memberid;
		this.username = username;
		this.password = password;
	}
}
