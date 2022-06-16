package model.Cards.Questions;

import java.util.HashMap;
import java.util.Objects;

import model.Cards.Answers.AnswerType;

/**
 * Abstract class for questions.
 */
public abstract class AbstractQuestion implements Question {
  private final String question;
  private final HashMap<String, AnswerType> answers;
  // Update AnswerType enum to just be Answer

  /**
   * Constructor for AbstractQuestion.
   *
   * @param question the question
   * @param answers  the possible answers
   * @throws IllegalArgumentException if question is null
   */
  protected AbstractQuestion(String question, HashMap<String, AnswerType> answers) throws IllegalArgumentException {
    this.question = Objects.requireNonNull(question);
    this.answers = Objects.requireNonNull(answers);
    this.getCorrectAnswers();
  }

  @Override
  abstract public String getQuestionType();

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
            this.getAnswers().equals(o.getAnswers());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.answers, this.question, this.getQuestionType());
  }

  @Override
  public HashMap<String, AnswerType> getCorrectAnswers() throws IllegalArgumentException {
    if (!this.answers.containsValue(AnswerType.CORRECT)) {
      throw new IllegalArgumentException("Required correct answer(s) not found");
    }

    HashMap<String, AnswerType> correctAnswers = new HashMap<>();
    this.answers.forEach((key, value) -> {
      if (value == AnswerType.CORRECT) {
        correctAnswers.put(key, value);
      }
    });

    return correctAnswers;
  }

  @Override
  public HashMap<String, AnswerType> getAnswers() {
    return this.answers;
  }

}
