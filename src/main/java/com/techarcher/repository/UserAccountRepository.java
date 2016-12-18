package com.techarcher.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techarcher.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

	public Optional<UserAccount> findByUsername(String username);
	
}
