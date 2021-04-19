package com.quizz.evaluacion.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="answersdto")*/
public class AnswerDto implements Serializable {
	
	private static final long serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnswer;

	@ElementCollection(targetClass=Answer.class)
	private List<Answer> answers;

	Long categoryId;
  

	public AnswerDto(List<Answer> answers, Long categoryId) {
		super();		
		this.answers = answers;
		this.categoryId = categoryId;
	}
	
	
	public Long getIdAnswer() {
		return idAnswer;
	}

	public void setIdAnswer(Long idAnswer) {
		this.idAnswer = idAnswer;
	}


	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
  
  
}
