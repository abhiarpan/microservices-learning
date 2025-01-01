package com.question.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepo;
import com.question.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	private QuestionRepo questionRepo;

	public QuestionServiceImpl(QuestionRepo questionRepo) {
	
		this.questionRepo = questionRepo;
	}

	@Override
	public Question create(Question question) {
		
		return questionRepo.save(question);
	}

	@Override
	public List<Question> get() {
		
		return questionRepo.findAll();
	}

	@Override
	public Question getById(Long id) {
		
		return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
	}
	
	
	  @Override public List<Question> getQuestionsOfQuiz(Long quizId) { return
	  questionRepo.findByQuizId(quizId); }
	 
}
