package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import Enviornment.ENV;


public class DatabaseImpl implements Database {

  private ResultSet result;
  private Connection connection;
  private Statement statement;
  private List<Deck> userDecks;
  private Entry<Integer, String> user;

  private final Map<Integer, Entry<String, String>> questions;
  private final List<Answer> answers;
  private final ArrayList<Question> questionList;

  DatabaseImpl() {
    userDecks = new ArrayList<>();
    questions = new HashMap<>();
    answers = new ArrayList<>();
    questionList = new ArrayList<>();
  }

  @Override
  public void start() throws SQLException {
    try {
      this.openConnection();
      this.callAPI();
    } finally {
      this.closeConnection();
    }
  }

  @Override
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

  @Override
  public void closeConnection() throws IllegalStateException {
    try {
      this.statement.close();
    } catch (SQLException e) {
      throw new IllegalStateException("Database connection is already closed!", e);
    }
  }

  /**
   * Collects the SQL data from the database, and stores it in the appropriate data structures.
   * <p>
   * Data such as:
   * - user_id
   * - deck name
   * - deck description
   * - question_id
   * - questions
   * - answers
   *
   * @throws SQLException if the database cannot be accessed
   */
  @Override
  public void callAPI() throws SQLException {
    this.setUser(1); // TODO: Change this to the current user

    this.result = this.executeQuery("SELECT * FROM deck WHERE user_id = " + this.user.getKey());

    Map<String, String> deckNames = new HashMap<>();

    // QUERY: Gets the users decks, all content
    while (this.result.next()) {
      deckNames.put(this.result.getString("name"), this.result.getString("description"));
    }

    for (Map.Entry<String, String> deck : deckNames.entrySet()) {
      System.out.println(deck.getKey() + ": " + deck.getValue());
      this.userDecks.add(new DeckImpl(deck.getKey(), deck.getValue(), this.getQuestions(deck.getKey())));
      System.out.println(this.userDecks.size());
    }
  }

  /**
   * Collects the questions from the database.
   *
   * @return the questions
   * @throws SQLException if the query fails
   */
  private Question[] getQuestions(String deckName) throws SQLException {
    this.result = this.executeQuery("SELECT *"
            + "FROM users u "
            + "JOIN deck d ON u.user_id = d.user_id "
            + "JOIN question q ON d.deck_id = q.deck_id "
            + "JOIN question_type qt ON q.question_type_id = qt.question_type_id "
            + "WHERE u.user_id = " + this.user.getKey() + " AND d.name = '" + deckName + "'");

    // QUERY: Gets the question's text, type
    while (this.result.next()) {
      questions.put(this.result.getInt("question_id"),
              new AbstractMap.SimpleEntry<>(this.result.getString("question"),
                      this.result.getString("question_type")));

    }

    this.getAnswers();

    return questionList.toArray(new Question[0]);
  }


  /**
   * Collects the answers from the database.
   *
   * @return the answers
   * @throws SQLException if the query fails
   */
  private Answer[] getAnswers() throws SQLException {
    for (Map.Entry<Integer, Map.Entry<String, String>> question : questions.entrySet()) {
      this.result = this.executeQuery("SELECT * FROM answers WHERE question_id = "
              + question.getKey());

      // QUERY: Gets the answer's text, correct/incorrect
      while (this.result.next()) {
        String answer = this.result.getString("answer");
        boolean correct = this.result.getBoolean("is_correct");

        answers.add(correct ? new CorrectAnswer(answer) : new IncorrectAnswer(answer));
      }

      this.setType(question);

      answers.clear();
    }
    return null;
  }

  /**
   * Sets the type of the question.
   *
   * @param question the question to set the type of
   */
  private void setType(Map.Entry<Integer, Map.Entry<String, String>> question) {
    switch (question.getValue().getValue()) {
      case "multiplechoice":
        questionList.add(new MultipleChoiceAnswer(question.getValue().getKey(),
                new ArrayList<>(answers)));
        break;
      case "shortanswer":
        questionList.add(new ShortAnswer(question.getValue().getKey(),
                new ArrayList<>(answers)));
        break;
      case "longanswer":
        questionList.add(new LongAnswer(question.getValue().getKey(),
                new ArrayList<>(answers)));
        break;
      default:
        break;
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

  /**
   * Executes a query on the database. If the query fails, the program will
   * exit and display an error message.
   *
   * @param query the query to be executed.
   * @return the result of the query.
   * @throws IllegalStateException if the query fails to execute
   */
  private ResultSet executeQuery(String query) throws IllegalStateException {
    try {
      return this.statement.executeQuery(query);
    } catch (SQLException e) {
      throw new IllegalStateException("Cannot execute the query!", e);
    }
  }

  /**
   * Executes an update on the database. This is used for inserts, updates, and deletes.
   *
   * @param query the query to be executed.
   * @return the result of the query.
   * @throws IllegalStateException if the query fails to execute
   */
  private int executeUpdate(String query) throws IllegalStateException {
    try {
      return this.statement.executeUpdate(query);
    } catch (SQLException e) {
      throw new IllegalStateException("Cannot execute the query!", e);
    }
  }

  /**
   * Sets the id of the user and the user's name into an Abstract hashmap.
   * This is used to store the user's id and name in the session.
   *
   * @param id the user's id
   */
  private void setUser(int id) throws SQLException {
    this.userDecks = new ArrayList<>();
    this.result = this.executeQuery("SELECT * FROM users WHERE user_id = " + id);

    /* QUERY: Gets the username and user id and stores them in a hashmap */
    this.result.next();
    int userID = this.result.getInt("user_id");
    String name = this.result.getString("name");
    this.user = new AbstractMap.SimpleEntry<>(userID, name);
  }
}
