package model.Cards.Answers;

/**
 * Enum for the different types of answers.
 */
public enum AnswerType implements Answer {
  CORRECT(), INCORRECT();

  private String answer;

  public AnswerType INCORRECT(String s) {
    answer = s;
    return INCORRECT;
  }

  public AnswerType CORRECT(String s) {
    answer = s;
    return CORRECT;
  }

  @Override
  public String getAnswer() {
    return answer;
  }
}
