package model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Enviornment.ENV;

/**
 * This {@code DatabaseStateImpl} class represents the state of the database. Handling the
 * connection between the database and the program.
 */
public class DatabaseStateImpl implements DatabaseState {

  private Connection connection;
  private Statement statement;

  @Override
  public boolean getState() {
    return connection != null;
  }

  public void openConnection() throws IllegalStateException {
    this.verifyDriver();

    String url = "jdbc:mysql://localhost:3306/card";

    try {
      this.connection = DriverManager.getConnection(url, "root", ENV.PASSWORD);
      this.statement = connection.createStatement();

    } catch (SQLException e) {
      throw new IllegalStateException("Cannot connect to the database!", e);
    }
  }

  public void closeConnection() throws IllegalStateException {
    try {
      this.statement.close();
    } catch (SQLException e) {
      throw new IllegalStateException("Database connection is already closed!", e);
    }
  }

  public ResultSet executeQuery(String query) throws IllegalStateException {
    try {
      return this.statement.executeQuery(query);
    } catch (SQLException e) {
      throw new IllegalStateException("Cannot execute the query!", e);
    }
  }

  public int executeUpdate(String query) throws IllegalStateException {
    try {
      return this.statement.executeUpdate(query);
    } catch (SQLException e) {
      throw new IllegalStateException("Cannot execute the query!", e);
    }
  }

  /**
   * Verifies that the sql server is running and the database is accessible.
   * If the database is not accessible, the program will throw an IllegalStateException.
   *
   * @throws IllegalStateException if the database is not accessible
   */
  private void verifyDriver() throws IllegalStateException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new IllegalStateException("Cannot find the JDBC driver!", e);
    }
  }
}