package model.Cards.Decks;

import model.Utils;

public final class DeckBuilder {
  private String name;
  private String description;

  public DeckBuilder name(String name) {
    this.name = name;
    return this;
  }

  public DeckBuilder description(String description) {
    this.description = description;
    return this;
  }

  public Deck build() throws IllegalArgumentException {
    Utils.requireNonNulls(this.name, this.description);

    return new DeckImpl(name, description);
  }
}
