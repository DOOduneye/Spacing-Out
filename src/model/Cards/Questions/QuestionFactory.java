package model.Cards.Questions;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import model.Cards.Answers.Answer;

public final class QuestionFactory {
  private final HashMap<QuestionType, BiFunction<String, List<Answer>, Question>> questionFactories;

  public QuestionFactory() {
    this.questionFactories = new HashMap<>();
    this.addQuestion();
  }

  public Question createQuestion(String question, List<Answer> answers, QuestionType type) {
    return this.questionFactories.get(type).apply(question, answers);
  }

  private void addQuestion() {
    questionFactories.put(QuestionType.MULTIPLE_CHOICE, MC::new);
    questionFactories.put(QuestionType.FILL_IN_THE_BLANK, FITB::new);
    questionFactories.put(QuestionType.SHORT_RESPONSE, SHORT::new);
    questionFactories.put(QuestionType.LONG_RESPONSE, LONG::new);
  }
}
