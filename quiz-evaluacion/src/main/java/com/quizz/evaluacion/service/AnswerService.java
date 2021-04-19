package com.quizz.evaluacion.service;

import java.util.List;

import com.quizz.evaluacion.model.AnswerDto;
import com.quizz.evaluacion.model.Result;

public interface AnswerService {
  List<Result> checkAnswer(AnswerDto answerDto);
}
