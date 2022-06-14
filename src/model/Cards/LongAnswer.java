package model.Cards;

import java.util.List;

public class LongAnswer extends AbstractQuestion {

  public LongAnswer(String question, List<Answer> answer) {
    super(question, answer);
  }

  @Override
  public String getQuestionType() {
    return "LongAnswer";
  }
}
