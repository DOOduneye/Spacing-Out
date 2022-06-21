package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

/**
 * This class represents the state of a true/false question.
 */
public final class TF extends AbstractQuestion {

  /**
   * Constructor for the True/False question.
   *
   * @param question the question
   * @param answer   the correct answer
   * @throws IllegalArgumentException if question is null
   */
  TF(String question, List<Answer> answer) {
    super(question, answer);
  }

  @Override
  public QuestionType getQuestionType() {
    return QuestionType.TRUE_FALSE;
  }
}
