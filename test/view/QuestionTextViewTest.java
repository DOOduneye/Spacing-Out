//package view;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import model.Cards.Questions.AbstractQuestion;
//import model.Cards.Answers.Answer;
//import model.Cards.Answers.CorrectAnswer;
//import model.Cards.Answers.IncorrectAnswer;
//
//public class QuestionTextViewTest {
//  private Answer answer1;
//  private Answer answer2;
//  private Answer answer3;
//  private AbstractQuestion question;
//  private ArrayList<Answer> answers;
//  private QuestionTextView questionTextView;
//
//  @Before
//  public void setUp() {
//    answer1 = new CorrectAnswer("Paris");
//    answer2 = new IncorrectAnswer("London");
//    answer3 = new IncorrectAnswer("New York");
//
//    answers = new ArrayList<Answer>(Arrays.asList(answer1, answer2, answer3));
//
//    question = new MultipleChoiceAnswer("What is the capital of france?", answers);
//    questionTextView = new QuestionTextView(question);
//  }
//
//  @Test
//  public void testToString() {
//    System.out.println(questionTextView.toString());
////    assertEquals("", questionTextView.toString());
//  }
//
//}