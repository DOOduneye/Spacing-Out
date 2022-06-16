//package view;
//
//import model.Cards.Answer.Answer;
//import model.Cards.Questions.Question;
//
//import java.io.IOException;
//import java.util.Objects;
//
///**
// * This class is used to display the question in a text format.
// */
//public class QuestionTextView implements QuestionView {
//  private final Question question;
//  private final Appendable out;
//  private final StringBuilder text;
//  private int letter;
//
//  /**
//   * Constructor for the QuestionTextView class.
//   *
//   * @param question The question to display.
//   */
//  public QuestionTextView(Question question) {
//    this(question, System.out);
//  }
//
//  /**
//   * Constructor for the QuestionTextView class.
//   *
//   * @param question The question to display.
//   * @param appendable The appendable to use.
//   */
//  public QuestionTextView(Question question, Appendable appendable) {
//    this.question = Objects.requireNonNull(question);
//    this.text = new StringBuilder();
//    this.out = appendable;
//  }
//
//  @Override
//  public String toString() {
//
//    text.append("*".repeat(Math.max(0, question.getQuestion().length() + 2)));
//    text.append(String.format("\n* %s *\n", question.getQuestion()));
//    text.append("*".repeat(Math.max(0, question.getQuestion().length() + 2)));
//    text.append("\n");
//
//    for (Answer answer : question.getAnswers()) {
//      text.append(getLetter()).append(") ").append(answer.getAnswer()).append("\n");
//    }
//
//    return text.toString();
//  }
//
//  @Override
//  public void render() throws IOException {
//    try {
//      out.append(toString());
//    } catch (IOException e) {
//      throw new IOException("Could not render question.", e);
//    }
//  }
//
//  @Override
//  public void render(String answer) throws IOException {
//    try {
//      out.append(answer);
//    } catch (IOException e) {
//      throw new IOException("Could not render answer.", e);
//    }
//  }
//
//  @Override
//  public void renderAll() throws IOException {
//
//  }
//
//  private String getLetter() {
//    return String.valueOf((char) (letter++ + 'A'));
//  }
//
//}
