//package view;
//
//import java.io.IOException;
//
///**
// * This class is the view for the question.
// */
//public interface QuestionView {
//
//  /**
//   * A method to represent a question with given answers.
//   *
//   * @return the visual representation of the question.
//   */
//  String toString();
//
//  /**
//   * Render the question to the provided data destination. The question should be rendered exactly
//   * in the format produced by the toString method above.
//   *
//   * @throws IOException if transmission of the question to the provided data destination fails
//   */
//  void render() throws IOException;
//
//  /**
//   * Render the message to the provided data destination.
//   *
//   * @param message the message to be rendered
//   * @throws IOException if transmission of the message to the provided data destination fails
//   */
//  void render(String message) throws IOException;
//
//  /**
//   * Render all the decks to the provided data destination.
//   *
//   * @throws IOException if transmission of the message to the provided data destination fails
//   */
//  void renderAll() throws IOException;
//}
