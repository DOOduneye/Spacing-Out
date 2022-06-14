package model.Cards;

import java.util.Objects;

/**
 * This class represents a correct answer.
 */
public class CorrectAnswer implements Answer {
  private final String answer;

  /**
   * Constructs a correct answer.
   *
   * @param answer the correct answer
   */
  public CorrectAnswer(String answer) {
    this.answer = Objects.requireNonNull(answer);
  }

  @Override
  public boolean isCorrect() {
    return true;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }
}
