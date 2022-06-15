package model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryImpl implements Query {
  private final Database database;
  private final Statement statement;

  // TODO: NEED to get the statement from the DatabaseState interface going through the database
  public QueryImpl(Database database) {
    this.database = database;
    // TODO: For now the query will open the database, need to reimplement later
    this.statement = database.open();
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
}
