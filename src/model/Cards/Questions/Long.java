package model.Cards.Questions;

import java.util.HashMap;

import model.Cards.Answers.AnswerType;

/**
 * This class represents the state of a long response question.
 */
public class Long extends AbstractQuestion {

  /**
   * Constructor for Long Questions.
   *
   * @param question the question
   * @param answer   the correct answer
   * @throws IllegalArgumentException if question is null
   */
  public Long(String question, HashMap<String, AnswerType> answer) {
    super(question, answer);
  }

  @Override
  public String getQuestionType() {
    return "LongAnswer";
  }
}
