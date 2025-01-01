package com.question.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;

	
	public QuestionController(QuestionService questionService) {
		
		this.questionService = questionService;
	}

	@PostMapping
	public ResponseEntity<Question> create(@RequestBody Question question) {
		
		return ResponseEntity.ok(questionService.create(question));
	}
	
	@GetMapping
	public List<Question> get(){
		
		return questionService.get();
	}
	
	@GetMapping("/{id}")
	public Question getById(@PathVariable Long id) {
		
		return questionService.getById(id);
	}
	
	
	  @GetMapping("/quiz/{quizId}") public List<Question>
	  getQuestionsOfQuiz(@PathVariable Long quizId) { return
	  questionService.getQuestionsOfQuiz(quizId); }
	 
}
