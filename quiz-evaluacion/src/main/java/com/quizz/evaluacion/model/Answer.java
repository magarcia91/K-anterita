package com.quizz.evaluacion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_answer")
public class Answer implements Serializable {
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnswer;
	private Question question;
	private Long selectedOption;
  
  
	public Long getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Long idAnswer) {
		this.idAnswer = idAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Long getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(Long selectedOption) {
		this.selectedOption = selectedOption;
	}
  
  
}
