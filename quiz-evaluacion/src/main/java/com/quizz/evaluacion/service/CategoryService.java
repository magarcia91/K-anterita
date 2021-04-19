package com.quizz.evaluacion.service;

import java.util.List;
import java.util.Optional;
import org.springframework.validation.BindingResult;

import com.quizz.evaluacion.model.Category;
import com.quizz.evaluacion.model.CategoryDto;

public interface CategoryService {

  List<Category> findAll();

  /*Find category by id */
  Optional<Category> findById(Long categoryId);

  /*Save category */
  Category save(Category category);

  /*Check if category already exits*/
  void checkCategoryExist(CategoryDto categoryDto, BindingResult bindingResult);

  /*Save multiple category*/
  CategoryDto saveAll(CategoryDto categoryDto);

  /*Update category */
  Category update(Category category);

  /*Delete category*/
  void delete(Long categoryId);
}
