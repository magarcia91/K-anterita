package com.quizz.evaluacion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@NoArgsConstructor
/*@Entity
@Table(name="result")*/
public class Result implements Serializable {
	
	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResult;
	private String questionText;
	private String correctAnswer;
	private String selectedAnswer;
	private boolean correct;
	

	public Long getIdResult() {
		return idResult;
	}

	public void setIdResult(Long idResult) {
		this.idResult = idResult;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
  
  
}
