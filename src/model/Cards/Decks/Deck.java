package model.Cards.Decks;

import java.util.List;

import model.Cards.Questions.Question;

/**
 * This class represents a deck of questions.
 */
public interface Deck extends DeckState {

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
   * Returns the questions in the deck.
   *
   * @return the questions in the deck
   */
  List<Question> getQuestions();

  /**
   * Returns the question at the given index.
   *
   * @param index the index of the question to return
   * @return the number of questions in the deck.
   */
  Question get(int index);

  /**
   * Returns the question with the given question.
   *
   * @param question the question to search for
   * @return the question with the given question
   */
  Question get(String question);
}
