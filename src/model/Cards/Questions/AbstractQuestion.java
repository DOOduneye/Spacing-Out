package model.Cards.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

import model.Cards.Answers.Answer;
import model.Cards.Answers.AnswerType;
import model.Utils;

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
    // might not be null due to where it is called from -> QuestionFactory.createQuestion
    this.question = Objects.requireNonNull(question);
    try {
      this.answers = Objects.requireNonNull(answers);
      Collections.shuffle(this.answers);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("You must have at least one correct answer");
    }
  }

  @Override
  abstract public QuestionType getQuestionType();

  @Override
  public String getQuestion() {
    return this.question;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }

    if (!(other instanceof AbstractQuestion)) {
      return false;
    }

    AbstractQuestion o = (AbstractQuestion) other;
    return this.getQuestionType().equals(o.getQuestionType()) &&
            this.getQuestion().equals(o.getQuestion()) &&
            this.getAnswers().equals(o.getAnswers()) &&
            Utils.compareList(this.getAnswers(), o.getAnswers());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.answers, this.question, this.getQuestionType());
  }

  @Override
  public List<Answer> getCorrectAnswers() throws IllegalArgumentException {
    List<Answer> correctAnswers = new ArrayList<>();

    for (Answer a : this.answers) {
      if (a.getType().equals(AnswerType.CORRECT)) {
        correctAnswers.add(a);
      }
    }

    if (correctAnswers.isEmpty()) {
      throw new IllegalArgumentException("No correct answers");
    }

    return correctAnswers;
  }

  @Override
  public List<Answer> getAnswers() {
    return this.answers;
  }
}
