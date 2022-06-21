package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

/**
 * This class represents the state of a short response question.
 */
public final class SHORT extends AbstractQuestion {

  /**
   * Constructor for Short Response Question.
   *
   * @param question the question
   * @param answer   the correct answer
   * @throws IllegalArgumentException if question is null
   */
  SHORT(String question, List<Answer> answer) {
    super(question, answer);
  }

  @Override
  public QuestionType getQuestionType() {
    return QuestionType.SHORT_RESPONSE;
  }
}
