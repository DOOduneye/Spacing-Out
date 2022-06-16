package model.Cards.Decks;

import java.util.List;

import model.Cards.Questions.Question;

/**
 * This {@code DeckImpl} represents a deck of questions. It is a concrete implementation of the
 * {@code Deck} interface.
 */
public class DeckImpl implements Deck {

  private final String name;
  private final String description;
  private final List<Question> questions;
  
  /**
   * Constructor for DeckImpl.
   *
   * @param name        the name of the deck
   * @param description the description of the deck
   * @param questions   the questions in the deck
   */
  public DeckImpl(String name, String description, List<Question> questions) {
    this.name = name;
    this.description = description;
    this.questions = questions;
  }

  @Override
  public List<Question> getQuestions() {
    return this.questions;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void add(Question question) {
    this.questions.add(question);
  }

  @Override
  public void addAll(List<Question> questions) {
    this.questions.addAll(questions);
  }

  @Override
  public void remove(Question question) {
    this.questions.remove(question);
  }

  @Override
  public void removeAll() {
    this.questions.clear();
  }

  @Override
  public Question get(int index) {
    return this.questions.get(index);
  }

  @Override
  public Question get(String question) {
    for (Question q : this.questions) {
      if (q.getQuestion().equals(question)) {
        return q;
      }
    }
    return null;
  }

  @Override
  public int size() {
    return this.questions.size();
  }

  @Override
  public boolean isEmpty() {
    return this.questions.isEmpty();
  }
}
