package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

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
   * Gets the correct answer(s).
   *
   * @return a hashmap of the correct answers. It is sort of redundant to have a
   * hashmap of the correct answers, but as we are currently working with an Enum, a
   * hashmap is the easiest way to go.
   * @throws IllegalStateException if no correct answer is found
   */
  List<Answer> getCorrectAnswers();

  /**
   * Gets the answer(s).
   *
   * @return the answer(s).
   */
  List<Answer> getAnswers();
}
