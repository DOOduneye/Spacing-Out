package model;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class represents a deck of questions.
 */
public interface Deck {
  /**
   * Removes the question.
   */
  void remove(Question question);

  /**
   * Adds a question to the deck.
   *
   * @param question the question to add
   */
  void add(Question question);

  Question get(int i);

  /**
   * Returns the question with the given question.
   *
   * @param question the question to search for
   * @return the question with the given question
   */
  Question get(String question);

  /**
   * Returns the questions in the deck.
   *
   * @return the questions in the deck
   */
  Question[] getQuestions();

  /**
   * Returns the name of the deck.
   *
   * @return the name of the deck
   */
  String getName();

  /**
   * Returns the description of the deck.
   *
   * @return the description of the deck
   */
  String getDescription();

  /**
   * Returns the number of questions in the deck.
   *
   * @return the number of questions in the deck
   */
  int size();
}
