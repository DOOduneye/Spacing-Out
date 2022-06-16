package controller;

/**
 * This {@code Controller} class is the controller of the MVC pattern. It is in charge of the
 * communication between the view and the model. Allowing the user to interact
 * either synchronously or asynchronously with the view.
 */
public interface Controller {

  /**
   * Initializes the controller.
   */
  void run() throws IllegalStateException;
}
