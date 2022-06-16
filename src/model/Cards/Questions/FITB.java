package model.Cards.Questions;

import java.util.HashMap;

import model.Cards.Answers.AnswerType;

/**
 * This class represents the state of a fill in the blank question.
 */
public class FITB extends AbstractQuestion {

  /**
   * Constructor for FillInTheBlank Questions.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  public FITB(String question, HashMap<String, AnswerType> answers) throws IllegalArgumentException {
    super(question, answers);
  }

  @Override
  public String getQuestionType() {
    return "Fill in the blank";
  }
}
