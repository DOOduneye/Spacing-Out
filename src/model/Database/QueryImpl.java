package model.Database;

import java.io.IOException;
import java.sql.Statement;

import model.Database.functions.DELETE;
import model.Database.functions.INSERT;
import model.Database.functions.SELECT;
import model.Database.functions.UPDATE;

public final class QueryImpl implements Query {
  private final Database database;
  private final Statement statement;
  private StringBuilder query;

  // TODO: NEED to get the statement from the DatabaseState interface going through the database
  public QueryImpl(Database database) {
    this.database = database;
    this.query = new StringBuilder();
    // TODO: For now the query will open the database, need to reimplement later
    this.statement = database.open();
  }

  @Override
  public QueryBuilder SELECT(String... columns) throws IOException {
    this.query = new StringBuilder();
    StringBuilder columnsString = new StringBuilder();
    for (int i = 0; i < columns.length; i++) {
      columnsString.append(columns[i]);
      if (i < columns.length - 1) {
        columnsString.append(", ");
      }
    }
    return new QueryBuilder(this.statement,
            query.append(new SELECT().apply(columnsString.toString())));
  }

  @Override
  public QueryBuilder INSERT(String table) throws IOException {
    return new QueryBuilder(this.statement, query.append(new INSERT().apply(table)));
  }

  @Override
  public QueryBuilder UPDATE(String table) throws IOException {
    return new QueryBuilder(this.statement, query.append(new UPDATE().apply(table)));
  }

  @Override
  public QueryBuilder DELETE(String table) throws IOException {
    return new QueryBuilder(this.statement, query.append(new DELETE().apply(table)));
  }

//  public ResultSet executeQuery(Function<String, String> function, String query) throws IllegalStateException {
//    try {
//      return this.statement.executeQuery(function.apply(query));
//    } catch (SQLException e) {
//      throw new IllegalStateException("Failed to execute query: " + query, e);
//    }
//  }
//
//  public void executeUpdate(Function<String, String> function, String query) throws IllegalStateException {
//    try {
//      this.statement.executeUpdate(function.apply(query));
//    } catch (SQLException e) {
//      throw new IllegalStateException("Cannot execute the query!", e);
//    }
//  }
}
