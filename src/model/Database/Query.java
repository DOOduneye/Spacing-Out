package model.Database;

import java.io.IOException;

/**
 * This class is used to create a query to be used in the database.
 * It is used to create a query that can be used to retrieve data from the database.
 * Queries are a hierarchical structure that can be used to retrieve data from the database.
 * The query is built by adding functions in a QueryBuilder object.
 */
public interface Query {

  QueryBuilder SELECT(String... columns) throws IOException;

  QueryBuilder INSERT(String table) throws IOException;

  QueryBuilder UPDATE(String table) throws IOException;

  QueryBuilder DELETE(String table) throws IOException;
}
