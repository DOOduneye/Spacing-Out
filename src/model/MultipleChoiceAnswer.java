package model;

import java.util.List;

/**
 * This class represents a multiple choice question.
 */
public class MultipleChoiceAnswer extends AbstractQuestion {
  public MultipleChoiceAnswer(String question, List<Answer> answers) {
    super(question, answers);
  }

  @Override
  public String getQuestionType() {
    return "MultipleChoiceAnswer";
  }

}
