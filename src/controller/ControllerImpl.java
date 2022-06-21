package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Cards.Decks.Deck;
import model.Database.CardData;
import view.CardTextView;

public class ControllerImpl implements Controller {
  private final CardData database;
  private final Scanner sc;
  private final CardTextView cardTextView;
  private List<Deck> decks;

  public ControllerImpl() {
    this.database = new CardData();
    this.cardTextView = new CardTextView();
    this.sc = new Scanner(System.in);
  }

  @Override
  public void run() throws IllegalStateException {
    this.render("Welcome to the card database!");
    this.showMenu();

    this.start(sc);
  }

  private void start(Scanner sc) throws IllegalStateException {
    int user;
    boolean quit = true;

    try {
      while (quit) {
        user = sc.nextInt();
        this.render("User: " + user + " selected.");
        this.render("Please select a deck to study:");
        this.decks = this.database.instantiate(user);
        this.showDeck(decks);
        quit = false;
      }
    } catch (SQLException e) {
      throw new IllegalStateException("SQL Error");
    }

  }

  private void showDeck(List<Deck> instantiate) {
    for (Deck deck : instantiate) {
      this.render("Deck: " + deck.getName());
    }
  }


  private void render(String message) {
    try {
      this.cardTextView.render(message + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  private void showMenu() {
    this.render("Please select a user:");
    try {
      this.database.getUsers().forEach((user, id) -> this.render("" + id + ": " + user));
    } catch (SQLException e) {
      throw new IllegalStateException("Could not get users");
    }
  }
}
