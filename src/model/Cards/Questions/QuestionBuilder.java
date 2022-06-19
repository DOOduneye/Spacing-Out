package model.Cards.Questions;

import java.util.ArrayList;
import java.util.List;

import model.Cards.Answers.Answer;
import model.Cards.Answers.AnswerFactory;
import model.Cards.Answers.AnswerType;
import model.Utils;

public final class QuestionBuilder {
  private String question;
  private QuestionType type;
  private final List<Answer> answers;

  public QuestionBuilder() {
    this.answers = new ArrayList<>();
  }

  public QuestionBuilder setQuestion(String question) {
    this.question = question;
    return this;
  }

  public QuestionBuilder addAnswer(String answer, AnswerType type) {
    this.answers.add(new AnswerFactory().createAnswer(answer, type));
    return this;
  }

  public QuestionBuilder addAllAnswers(List<Answer> answers) {
    this.answers.addAll(answers);
    return this;
  }

  public QuestionBuilder setType(QuestionType type) {
    this.type = type;
    return this;
  }

  private boolean isValid() {
    for (Answer answer : answers) {
      if (answer.getType() == AnswerType.CORRECT) {
        return true;
      }
    }
    return false;
  }

  public Question build() throws IllegalArgumentException {
    Utils.requireNonNulls(this.question, this.answers, this.type);

    if (!isValid()) {
      throw new IllegalArgumentException("Question must have at least one correct answer");
    }

    return new QuestionFactory().createQuestion(this.question, this.answers, this.type);
  }

}
