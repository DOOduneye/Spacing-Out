package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

/**
 * This class represents the state of a fill in the blank question.
 */
public final class FITB extends AbstractQuestion {

  /**
   * Constructor for FillInTheBlank Questions.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  FITB(String question, List<Answer> answers) throws IllegalArgumentException {
    super(question, answers);
  }

  @Override
  public QuestionType getQuestionType() {
    return QuestionType.FILL_IN_THE_BLANK;
  }
}
