package model.Cards.Questions;

// TODO: MAKE THIS A FACTORY BUILDER SINCE I CAN MAKE ANY TYPE OF QUESTION

/**
 * This class represents a question, with a question and a correct answer.
 */
public interface Question extends QuestionState {

  /**
   * Whether the question is equivalent to another question.
   *
   * @param other the other question
   * @return the answer as a string.
   */
  boolean equals(Object other);

  /**
   * The hash code for the question type.
   *
   * @return the hash code.
   */
  int hashCode();
}
