package com.quiz.entities;

public class Question {

	private Long questionId;
	
	private String question;
	
	private String quizId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long id) {
		this.questionId = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	
	
}
