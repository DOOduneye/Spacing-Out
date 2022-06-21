package model.Database;

import java.sql.Statement;


/**
 * This {@code Database} enum represents the database. It is a single-element enum--only allowing
 * one instance of the enum to be created, and is used to connect to the database
 */
public enum Database {

  INSTANCE;

  private final DatabaseState state;

  /**
   * Constructs the database
   */
  Database() {
    this.state = new DatabaseStateImpl();
  }

  /**
   * Returns the instance of the database
   *
   * @return the instance of the database
   */
  public static Database instance() {
    return INSTANCE;
  }

  /**
   * Opens the database
   *
   * @return the {@code Statement} to be used in the database
   * @throws IllegalStateException if the database is already open, or if it cannot be opened
   */
  public Statement open() throws IllegalStateException {
    return this.state.openConnection();
  }

  /**
   * Closes the database
   *
   * @throws IllegalStateException if the database is already closed, or if it cannot be closed
   */
  public void close() throws IllegalStateException {
    this.state.closeConnection();
  }
}