package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	private List<Student> listStudent = new ArrayList<>(List.of(
			new Student("Abhi",1, 18),
			new Student("test",2,17)
			));
	
	@GetMapping("/students")
	public List<Student> getStudent(){
		
		return listStudent;
	}
	
	@GetMapping("/token")
	public CsrfToken getCsrfToken( HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	
	@PostMapping("/students")
	public List<Student> addStudent(@RequestBody Student student) {
		
		listStudent.add(student);
		return listStudent;
	}

}
