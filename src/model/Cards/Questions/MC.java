package model.Cards.Questions;

import java.util.List;

import model.Cards.Answers.Answer;

/**
 * This class represents the state of a multiple choice question.
 */
public final class MC extends AbstractQuestion {

  /**
   * Constructor for MultipleChoice Questions.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  MC(String question, List<Answer> answers) {
    super(question, answers);
  }

  @Override
  public String getQuestionType() {
    return "MultipleChoiceAnswer";
  }

}
