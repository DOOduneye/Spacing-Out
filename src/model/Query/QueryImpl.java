package model.Query;

import java.sql.Statement;

import model.Database.Database;
import model.Query.functions.DELETE;
import model.Query.functions.INSERT;
import model.Query.functions.SELECT;
import model.Query.functions.UPDATE;

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
  public QueryBuilder SELECT(String... columns) {
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
  public QueryBuilder INSERT(String table)  {
    return new QueryBuilder(this.statement, query.append(new INSERT().apply(table)));
  }

  @Override
  public QueryBuilder UPDATE(String table)  {
    return new QueryBuilder(this.statement, query.append(new UPDATE().apply(table)));
  }

  @Override
  public QueryBuilder DELETE(String table)  {
    return new QueryBuilder(this.statement, query.append(new DELETE().apply(table)));
  }
}
