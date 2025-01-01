package com.quiz.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionClient questionClient;
	

	/*
	 * public QuizServiceImpl(QuizRepository quizRepository, QuestionClient
	 * questionClient) { super(); this.quizRepository = quizRepository;
	 * this.questionClient = questionClient; }
	 */

	@Override
	public Quiz add(Quiz quiz) {
		System.out.println("quiz title"+quiz.toString());
		
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
	
		List<Quiz> allQuiz = quizRepository.findAll();
		List<Quiz> quizList = allQuiz.stream().map(quiz ->{
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return quizList;
	}

	@Override
	public Quiz get(Long id) {
		
		 Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("No Record found"));
		 quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		 return quiz;
	}

}
