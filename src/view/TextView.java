package view;

import java.io.IOException;

/**
 * This class is the view of the game. It is responsible for displaying the game to the user.
 */
public interface TextView {
  /**
   * Render the message to the provided data destination.
   *
   * @param message the message to be rendered
   * @return
   * @throws IOException if transmission of the message to the provided data destination fails
   */
  void render(String message) throws IOException;
}
