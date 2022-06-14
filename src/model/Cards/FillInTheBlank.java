package model.Cards;

import java.util.List;

public class FillInTheBlank extends AbstractQuestion {

  /**
   * Constructor for FillInTheBlank Questions.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  public FillInTheBlank(String question, List<Answer> answers)
          throws IllegalArgumentException {
    super(question, answers);
  }

  @Override
  public String getQuestionType() {
    return "Fill in the blank";
  }
}
