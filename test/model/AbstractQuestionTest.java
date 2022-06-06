package model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * A class to test the AbstractQuestion class.
 */
public class AbstractQuestionTest {

  private AbstractQuestion question;
  private AbstractQuestion question2;
  private AbstractQuestion question3;
  private Answer answer;
  private Answer answer2;
  private Answer answer3;
  private ArrayList<Answer> answers;


  @Before
  public void setUp() {
    answers = new ArrayList<>();

    answer = new CorrectAnswer("Paris");
    answer2 = new IncorrectAnswer("London");
    answer3 = new IncorrectAnswer("Madrid");

    answers.add(answer);
    answers.add(answer2);
    answers.add(answer3);

    question = new MultipleChoiceAnswer("What is the capital of France?", answers);
    question2 = new LongAnswer("What is the capital of France?", answers);
    question3 = new ShortAnswer("What is the capital of France?", answers);
  }

  @Test
  public void getQuestionType() {
    assertEquals(question.getQuestionType(), "MultipleChoiceAnswer");
    assertEquals(question2.getQuestionType(), "LongAnswer");
    assertEquals(question3.getQuestionType(), "ShortAnswer");
  }

  @Test
  public void getQuestion() {
    assertEquals(question.getQuestion(), "What is the capital of France?");
    assertEquals(question2.getQuestion(), "What is the capital of France?");
    assertEquals(question3.getQuestion(), "What is the capital of France?");
  }

  @Test
  public void testEquals() {
    assertFalse(question.equals(question2));
    assertFalse(question.equals(question3));
    assertTrue(question.equals(question));
  }

  @Test
  public void testHashCode() {
    assertEquals(question.hashCode(), question.hashCode());
    assertNotEquals(question2.hashCode(), question.hashCode());
    assertEquals(question3.hashCode(), question3.hashCode());
  }

  @Test
  public void testGetCorrectAnswer() {
    assertEquals(question.getCorrectAnswer(), answer);
    assertNotEquals(question.getCorrectAnswer(), answer2);
  }
}