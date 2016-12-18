package com.techarcher.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserAccount {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	
	UserAccount() { // For JPA
		
	}
	
	public UserAccount(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
