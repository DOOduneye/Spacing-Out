package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

/**
 * This class represents the state of a long response question.
 */
public final class LONG extends AbstractQuestion {

  /**
   * Constructor for Long Response Question.
   *
   * @param question the question
   * @param answer   the correct answer
   * @throws IllegalArgumentException if question is null
   */
  LONG(String question, List<Answer> answer) {
    super(question, answer);
  }

  @Override
  public String getQuestionType() {
    return "LongAnswer";
  }
}
