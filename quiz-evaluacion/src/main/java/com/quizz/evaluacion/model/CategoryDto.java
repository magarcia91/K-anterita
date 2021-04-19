package com.quizz.evaluacion.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name="categorydto")*/
public class CategoryDto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	 
	@ElementCollection(targetClass=Category.class)
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
  
}
