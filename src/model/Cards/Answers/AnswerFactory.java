package model.Cards.Answers;

import java.util.HashMap;
import java.util.function.BiFunction;

public class AnswerFactory {

private final HashMap<AnswerType, BiFunction<String, AnswerType, Answer>> answerFactories;

  public AnswerFactory() {
    this.answerFactories = new HashMap<>();
    this.addAnswers();
  }

  public Answer createAnswer(String answer, AnswerType type) {
    return this.answerFactories.get(type).apply(answer, type);
  }

  private void addAnswers() {
    answerFactories.put(AnswerType.CORRECT, CorrectAnswer::new);
    answerFactories.put(AnswerType.INCORRECT, IncorrectAnswer::new);
  }
}
