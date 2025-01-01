package com.question.service;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	public Question create(Question question);
	
	public List<Question> get();
	
	public Question getById(Long id);
	
	List<Question> getQuestionsOfQuiz(Long quizId); 
}
