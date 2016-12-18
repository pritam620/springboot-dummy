package com.techarcher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.techarcher.entity.UserAccount;
import com.techarcher.repository.UserAccountRepository;

@SpringBootApplication
public class SpringbootlearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootlearnApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserAccountRepository repo) {
		return (x)-> {
			repo.save(new UserAccount("pritam", "pritam"));
			System.out.println("pritam saved");
			repo.save(new UserAccount("sarita", "pritam"));
		};
	}
}
