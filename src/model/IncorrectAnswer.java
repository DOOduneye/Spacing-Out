package model;

import java.util.Objects;

/**
 * This class represents an incorrect answer.
 */
public class IncorrectAnswer implements Answer {
  private final String answer;

  /**
   * Constructs an incorrect answer.
   *
   * @param answer the answer
   */
  public IncorrectAnswer(String answer) {
    this.answer = Objects.requireNonNull(answer);
  }

  @Override
  public boolean isCorrect() {
    return false;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }
}
