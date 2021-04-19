package com.quizz.evaluacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizz.evaluacion.model.AnswerDto;
import com.quizz.evaluacion.model.Option;
import com.quizz.evaluacion.model.Question;
import com.quizz.evaluacion.model.Result;

@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

  @Autowired QuestionService questionService;

  @Override
  public List<Result> checkAnswer(AnswerDto answerDto) {
    List<Result> results = new ArrayList<>();
    Long categoryId = answerDto.getCategoryId();

    answerDto
        .getAnswers()
        .forEach(
            answer -> {
             // log.info(answer.toString());
              Question question =
                  questionService.findById(answer.getQuestion().getId()).orElse(null);
              if (question != null) {
              //  log.info(question.toString());
                Option correctOption =
                    question.getOptions().values().stream()
                       // .filter(Option::isCorrect)
                        .findFirst()
                        .orElse(new Option());
                Option selectedOption;
                if (answer.getSelectedOption() != -1) {
                   selectedOption = question.getOptions().get(answer.getSelectedOption());
                }else{
                  selectedOption = new Option();
                }
                Result result = new Result();
                result.setQuestionText(question.getText());
                result.setSelectedAnswer(selectedOption.getText());
                result.setCorrectAnswer(correctOption.getText());
                result.setCorrect(selectedOption.isCorrect());
                results.add(result);
              }
            });
    return results;
  }
}
