package model;

/**
 * This class represents an answer to a question.
 */
public interface Answer {

  /**
   * The answer's correctness.
   *
   * @return true if the answer is correct, false otherwise.
   */
  boolean isCorrect();

  /**
   * The answer.
   *
   * @return the answer as a string.
   */
  String getAnswer();
}
