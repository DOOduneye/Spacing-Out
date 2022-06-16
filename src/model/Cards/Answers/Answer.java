package model.Cards.Answers;

/**
 * This class represents an answer to a question.
 */
public interface Answer {

  /**
   * The answer's correctness.
   *
   * @return true if the answer is correct, false otherwise.
   */
  default boolean isCorrect() {
    return false;
  }

  /**
   * The answer.
   *
   * @return the answer as a string.
   */
  String getAnswer();
}
