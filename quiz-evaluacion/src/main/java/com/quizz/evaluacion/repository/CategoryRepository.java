package com.quizz.evaluacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quizz.evaluacion.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
