package controller;

import java.io.IOException;

/**
 * This class is used to control inputs to create and hold questions.
 */
public interface QuestionController {

  /**
   * This method is used to create a question, and add it to the database.
   */
  public void run() throws IllegalStateException, IOException;
}
