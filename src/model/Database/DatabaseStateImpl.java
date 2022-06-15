package model.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Enviornment.ENV;

/**
 * This {@code DatabaseStateImpl} class represents the state of the database. Handling the
 * connection between the database and the program.
 */
// TODO: figure out how to protect this class, either through making it package-private or
//  private or protected
public final class DatabaseStateImpl implements DatabaseState {

  private Connection connection;
  private Statement statement;

  @Override
  public boolean getState() {
    return connection != null;
  }

  public Statement openConnection() throws IllegalStateException {
    this.verifyDriver();

    String url = "jdbc:mysql://localhost:3306/card";

    try {
      this.connection = DriverManager.getConnection(url, "root", ENV.PASSWORD);
      this.statement = connection.createStatement();

    } catch (SQLException e) {
      throw new IllegalStateException("Cannot connect to the database!", e);
    }

    return this.statement;
  }

  public void closeConnection() throws IllegalStateException {
    try {
      this.statement.close();
    } catch (SQLException e) {
      throw new IllegalStateException("Database connection is already closed!", e);
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
