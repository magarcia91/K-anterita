package com.quizz.evaluacion.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/*@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="options")*/
public class Option implements Serializable {
	
  private static final long serialVersionUID = 1;
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOption;
	private String text;
	private boolean correct;
  
	  
	public Long getIdOption() {
		return idOption;
	}

	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}  
  
}
