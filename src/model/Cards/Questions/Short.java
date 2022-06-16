package model.Cards.Questions;

import java.util.HashMap;

import model.Cards.Answers.AnswerType;

/**
 * This class represents the state of a short response question.
 */
public class Short extends AbstractQuestion {

  /**
   * Constructor for Short Questions.
   *
   * @param question the question
   * @param answer   the correct answer
   * @throws IllegalArgumentException if question is null
   */
  public Short(String question, HashMap<String, AnswerType> answer) {
    super(question, answer);
  }

  @Override
  public String getQuestionType() {
    return "ShortAnswer";
  }
}
