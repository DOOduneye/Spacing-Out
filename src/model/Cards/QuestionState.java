package model.Cards;

import java.util.List;

/**
 * This class represents the state of a question.
 */
public interface QuestionState {

  /**
   * The question type.
   *
   * @return the question type as a string.
   */
  String getQuestionType();

  /**
   * Returns the question text.
   *
   * @return the question text
   */
  String getQuestion();

  /**
   * Gets the correct answer.
   *
   * @return the correct answer
   * @throws IllegalStateException if no correct answer is found
   */
  Answer getCorrectAnswer();

  /**
   * Gets the answer(s).
   *
   * @return the answer(s).
   */
  List<Answer> getAnswers();
}
