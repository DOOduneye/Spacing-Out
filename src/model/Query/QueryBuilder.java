package model.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Database.functions.AND;
import model.Database.functions.FROM;
import model.Database.functions.GROUP;
import model.Database.functions.JOIN;
import model.Database.functions.ON;
import model.Database.functions.ORDER;
import model.Database.functions.UNION;
import model.Database.functions.WHERE;

public class QueryBuilder {
  private final StringBuilder query;
  private final Statement statement;

  public QueryBuilder(Statement statement, StringBuilder query) {
    this.query = query;
    this.statement = statement;
  }

  public QueryBuilder FROM(String table) {
    query.append(new FROM().apply(valid(table)));
    return this;
  }

  public QueryBuilder WHERE(String condition) {
    query.append(new WHERE().apply(valid(condition)));
    return this;
  }

  public QueryBuilder JOIN(String table) {
    query.append(new JOIN().apply(valid(table)));
    return this;
  }

  public QueryBuilder ON(String condition) {
    query.append(new ON().apply(valid(condition)));
    return this;
  }

  public QueryBuilder GROUP(String condition) {
    query.append(new GROUP().apply(valid(condition)));
    return this;
  }

  public QueryBuilder ORDER(String condition) {
    query.append(new ORDER().apply(valid(condition)));
    return this;
  }

  public QueryBuilder AND(String condition) {
    query.append(new AND().apply(valid(condition)));
    return this;
  }

  public QueryBuilder UNION(String condition) {
    query.append(new UNION().apply(valid(condition)));
    return this;
  }

  /**
   * Executes a built query on the database. If the query fails, the program will exit and
   * display an error message.
   *
   * @return the result of the query.
   * @throws IllegalStateException if the query fails to execute
   */
  public ResultSet query() {
    try {
      return this.statement.executeQuery(query.toString());
    } catch (SQLException e) {
      throw new IllegalStateException("Failed to execute query: " + query, e);
    }
  }

  private String valid(String sanitize) {
    if (sanitize == null) {
      return "";
    }

    for (String invalid : invalids()) {
      sanitize = sanitize.replaceAll(invalid, "");
    }

    return sanitize;
  }

  private String[] invalids() {
    return new String[]{"SELECT", "FROM", "WHERE", "JOIN", "ON", "GROUP", "ORDER", "AND", "DELETE"};
  }
}
