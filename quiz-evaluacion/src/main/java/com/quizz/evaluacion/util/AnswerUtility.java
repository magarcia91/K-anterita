package com.quizz.evaluacion.util;

import java.util.ArrayList;
import java.util.List;

import com.quizz.evaluacion.model.Answer;
import com.quizz.evaluacion.model.Question;

public class AnswerUtility {

  public static List<Answer> createAnswerList(List<Question> questionList) {
    List<Answer> answerList = new ArrayList<>(questionList.size());
    questionList.forEach(
        question -> {
          answerList.add(new Answer());
        });
    return answerList;
  }
}
