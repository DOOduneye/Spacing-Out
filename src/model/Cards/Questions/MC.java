package model.Cards.Questions;

import java.util.HashMap;

import model.Cards.Answers.AnswerType;

/**
 * This class represents the state of a multiple choice question.
 */
public class MC extends AbstractQuestion {

  /**
   * Constructor for MultipleChoice Questions.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  public MC(String question, HashMap<String, AnswerType> answers) {
    super(question, answers);
  }

  @Override
  public String getQuestionType() {
    return "MultipleChoiceAnswer";
  }

}
