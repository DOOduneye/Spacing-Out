package model;

import java.util.List;

public class ShortAnswer extends AbstractQuestion {

  public ShortAnswer(String question, List<Answer> answer) {
    super(question, answer);
  }

  @Override
  public String getQuestionType() {
    return "ShortAnswer";
  }
}
