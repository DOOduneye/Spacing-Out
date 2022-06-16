package model.Query;

/**
 * This class is used to create a query that can be used to retrieve data from the database.
 * Queries are a hierarchical structure that builds upon each other, to then build a query, taking
 * advantage of the builder pattern.
 */
public interface Query {

  /**
   * Selects the columns from the database.
   *
   * @param columns The columns to select from the database.
   * @return The QueryBuilder object.
   */
  QueryBuilder SELECT(String... columns);

  /**
   * Inserts data into the database.
   *
   * @param table The table to insert the data into.
   * @return The QueryBuilder object.
   */
  QueryBuilder INSERT(String table);

  /**
   * Updates data in the database.
   *
   * @param table The table to update the data in.
   * @return The QueryBuilder object.
   */
  QueryBuilder UPDATE(String table);

  /**
   * Deletes data from the database.
   *
   * @param table The table to delete the data from.
   * @return The QueryBuilder object.
   */
  QueryBuilder DELETE(String table);
}
