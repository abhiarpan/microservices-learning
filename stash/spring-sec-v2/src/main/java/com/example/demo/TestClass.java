package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestClass {
	
	@GetMapping("/")
	public String greetMessage() {
		return "welcome!!!!!";
	}

}
