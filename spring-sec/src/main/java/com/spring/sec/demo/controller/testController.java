package com.spring.sec.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	
	@GetMapping("/")
	public String greetMessage() {
		
		return "Welcome to Spring Security learning !!!";
	}

}
