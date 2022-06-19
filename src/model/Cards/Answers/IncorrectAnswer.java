package model.Cards.Answers;

import java.util.Objects;

/**
 * This class represents a correct answer.
 */
public final class IncorrectAnswer implements Answer {
  private final String answer;
  private final AnswerType type;

  /**
   * Constructs a correct answer.
   *
   * @param answer the correct answer
   */
  public IncorrectAnswer(String answer, AnswerType answerType) {
    this.answer = Objects.requireNonNull(answer);
    this.type = Objects.requireNonNull(answerType);
  }

  @Override
  public AnswerType getType() {
    return this.type;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }
}
