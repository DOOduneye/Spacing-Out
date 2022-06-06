package model;

public class DeckImpl implements Deck {

  private final String name;
  private final String description;
  private Question[] questions;

  public DeckImpl(String name, String description, Question[] questions) {
    this.name = name;
    this.description = description;
    this.questions = questions;
  }

  @Override
  public void remove(Question question) {
    Question[] newQuestions = new Question[this.questions.length - 1];
    int i = 0;
    for (Question q : this.questions) {
      if (q != question) {
        newQuestions[i++] = q;
      }
    }
    this.questions = newQuestions;

  }

  @Override
  public void add(Question question) {
    Question[] newQuestions = new Question[this.questions.length + 1];
    System.arraycopy(this.questions, 0, newQuestions, 0, this.questions.length);
    newQuestions[this.questions.length] = question;
    this.questions = newQuestions;
  }

  @Override
  public Question get(int i) {
    return this.questions[i];
  }

  public Question get(String question) {
    for (Question q : this.questions) {
      if (q.getQuestion().equals(question)) {
        return q;
      }
    }
    return null;
  }

  public Question[] getQuestions() {
    return this.questions;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public int size() {
    return this.questions.length;
  }

}
