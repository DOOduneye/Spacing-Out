package model.Database;

import java.sql.Statement;

/**
 * This interface represents the state of a database. It allows you to open a connection
 * to the database, and close the connection. As well as getting the current state of the
 * database.
 */
interface DatabaseState {

  /**
   * Returns the current state of the database.
   *
   * @return true if the database is open, false otherwise.
   */
  boolean getState();

  /**
   * Opens a connection to the database. If the connection fails, the program
   * will throw an IllegalStateException. If the connection is successful, the connection will be
   * stored in the statement variable.
   *
   * @throws IllegalStateException if it cannot connect to the database
   */
  Statement openConnection() throws IllegalStateException;

  /**
   * Closes the database connection. If the connection is already closed, the program
   * will throw an IllegalStateException.
   *
   * @throws IllegalStateException if the connection is already closed
   */
  void closeConnection() throws IllegalStateException;
}
