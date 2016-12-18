package com.techarcher.web.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.techarcher.entity.UserAccount;
import com.techarcher.repository.UserAccountRepository;

@EnableWebSecurity
@Configuration
public class SpringBootSecurity extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserAccountRepository userRepo;
	
	
	protected UserDetailsService userDetailsService() {
		return (String userName) -> {
			//we can write logic for getting the user from the database
			Optional<UserAccount> userAccout = userRepo.findByUsername(userName);
			if(userAccout.isPresent()) {
				UserAccount userAccountObj = userAccout.get();
			return new User(userAccountObj.getUsername(), userAccountObj.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
			}
			else throw new UsernameNotFoundException(userName + "not found in database");
		};
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

}
