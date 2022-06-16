package model.Cards.Questions;

import java.util.HashMap;

import model.Cards.Answers.AnswerType;

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

  // TODO: Fix Answer class / Enum
  /**
   * Gets the correct answer(s).
   *
   * @return a hashmap of the correct answers. It is sort of redundant to have a
   * hashmap of the correct answers, but as we are currently working with an Enum, a
   * hashmap is the easiest way to go.
   * @throws IllegalStateException if no correct answer is found
   */
  HashMap<String, AnswerType> getCorrectAnswers();

  /**
   * Gets the answer(s).
   *
   * @return the answer(s).
   */
  HashMap<String, AnswerType> getAnswers();
}
