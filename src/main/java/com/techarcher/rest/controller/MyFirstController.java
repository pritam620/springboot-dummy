package com.techarcher.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
	
	@RequestMapping("/hello/{username}")
	public String greeting(@PathVariable String username) {
		return "Hello " + username +" !";
	}
}
