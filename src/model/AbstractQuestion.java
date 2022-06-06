package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Abstract class for questions.
 */
public abstract class AbstractQuestion implements Question {
  private final String question;
  private final List<Answer> answers;

  /**
   * Constructor for AbstractQuestion.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  protected AbstractQuestion(String question, List<Answer> answers) throws IllegalArgumentException {
    this.question = Objects.requireNonNull(question);
    try {
      this.answers = Objects.requireNonNull(answers);
//      this.getCorrectAnswer();
      Collections.shuffle(this.answers);
    } catch (IllegalStateException e) {
      throw new IllegalArgumentException("Required correct answer not found");
    }
  }

  @Override
  abstract public String getQuestionType();

  @Override
  public String getQuestion() {
    return this.question;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof AbstractQuestion)) {
      return false;
    }

    AbstractQuestion other = (AbstractQuestion) o;
    return this.getQuestionType().equals(other.getQuestionType()) &&
            this.getQuestion().equals(other.getQuestion()) &&
            this.getCorrectAnswer().equals(other.getCorrectAnswer());

  }

  @Override
  public int hashCode() {
    return Objects.hash(this.answers, this.question, this.getQuestionType());
  }

  @Override
  public Answer getCorrectAnswer() throws IllegalStateException {
    for (Answer a : answers) {
      if (a.isCorrect()) {
        return a;
      }
    }
    throw new IllegalStateException("No correct answer found");
  }

  @Override
  public List<Answer> getAnswers() {
    return this.answers;
  }
}
