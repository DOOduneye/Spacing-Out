package model.Database;

import java.sql.ResultSet;

/**
 * This interface represents the state of a database. It allows you to open a connection
 * to the database, and close the connection. As well as getting the current state of the
 * database.
 */
public interface DatabaseState {

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
  void openConnection() throws IllegalStateException;

  /**
   * Closes the database connection. If the connection is already closed, the program
   * will throw an IllegalStateException.
   *
   * @throws IllegalStateException if the connection is already closed
   */
  void closeConnection() throws IllegalStateException;

  /**
   * Executes a query on the database. If the query fails, the program will exit and display an
   * error message.
   *
   * @param query the query to be executed.
   * @return the result of the query.
   * @throws IllegalStateException if the query fails to execute
   */
  ResultSet executeQuery(String query) throws IllegalStateException;

  /**
   * Executes an update on the database. This is used for inserts, updates, and deletes. This is
   * used for inserts, updates, and deletes.
   *
   * @param query the query to be executed.
   * @return the result of the query.
   * @throws IllegalStateException if the query fails to execute
   */
  int executeUpdate(String query) throws IllegalStateException;
}
