package model.Cards.Decks;

import java.util.List;

import model.Cards.Questions.Question;

public interface DeckState {

  /**
   * Removes the question.
   */
  void remove(Question question);

  /**
   * Removes all questions.
   */
  void removeAll();

  /**
   * Adds a question to the deck.
   *
   * @param question the question to add
   */
  void add(Question question);

  /**
   * Adds all questions to the deck.
   *
   * @param questions the questions to add
   */
  void addAll(List<Question> questions);

  /**
   * Returns the number of questions in the deck.
   *
   * @return the number of questions in the deck
   */
  int size();

  /**
   * Returns whether the deck is empty.
   *
   * @return true if the deck is empty, false otherwise
   */
  boolean isEmpty();

}
