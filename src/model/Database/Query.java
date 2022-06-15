package model.Database;

import java.sql.ResultSet;

public interface Query {

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
