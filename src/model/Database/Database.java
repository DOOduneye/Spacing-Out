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

  public static Database instance() {
    return INSTANCE;
  }

  // TODO: 'Statement' used without 'try'-with-resources statement whatever this means
  public Statement open() throws IllegalStateException {
    return this.state.openConnection();
  }

  public void close() throws IllegalStateException {
    this.state.closeConnection();
  }
}