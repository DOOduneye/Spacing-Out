package model;

/**
 * This class represents the database of flash cards. It contains methods to
 * that allow you to get data from the database. It allows you to open a connection
 * to the database, and close the connection.
 */
public interface Database {

  /**
   * Opens a connection to the database. If the connection fails, the program
   * will throw an IllegalStateException. If the connection is successful, the connection will be
   * stored in the statement variable.
   *
   * @throws Exception if it cannot connect to the database
   */
  void openConnection() throws Exception;

  /**
   * Closes the database connection. If the connection is already closed, the program
   * will throw an IllegalStateException.
   *
   * @throws Exception if the connection is already closed
   */
  void closeConnection() throws Exception;

  /**
   * Opens the connection to the database. This method should be called before any other
   * method in this class.
   *
   * @throws Exception if the connection cannot be opened
   */
  void start() throws Exception;

  /**
   * Gets all the data from the database.
   *
   * @throws Exception if the data cannot be retrieved
   */
  void callAPI() throws Exception;

}