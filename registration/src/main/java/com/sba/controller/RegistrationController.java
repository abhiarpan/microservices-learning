/**
 * 
 */
package com.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sba.entity.UserProfiles;
import com.sba.service.RegistartionService;

/**
 * 
 */

@RestController
@RequestMapping("/reg")
public class RegistrationController {
	@Autowired
	private RegistartionService registartionServicer;
	
	@PostMapping("/register")
	public ResponseEntity<UserProfiles> registation(@RequestBody UserProfiles user){
		
		System.out.println(user);
		UserProfiles userRes=registartionServicer.register(user);
		
		
		return new ResponseEntity<UserProfiles>(userRes,HttpStatus.OK);
		
	}

	@GetMapping("/getuser/{uid}")
	public ResponseEntity<UserProfiles> registation(@PathVariable Long uid){
		
		UserProfiles userRes=registartionServicer.getUserDetails(uid);
		return new ResponseEntity<UserProfiles>(userRes,HttpStatus.OK);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserProfiles> login(@RequestBody UserProfiles user){
		
		UserProfiles userRes=registartionServicer.Login(user);
		return new ResponseEntity<UserProfiles>(userRes,HttpStatus.OK);
		
	}
	
	
}
