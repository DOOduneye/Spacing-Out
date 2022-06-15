package model.Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

import model.Cards.Answer;
import model.Cards.CorrectAnswer;
import model.Cards.Deck;
import model.Cards.DeckImpl;
import model.Cards.IncorrectAnswer;
import model.Cards.LongAnswer;
import model.Cards.MultipleChoiceAnswer;
import model.Cards.Question;
import model.Cards.ShortAnswer;

public class FlashCardDatabase {
  private final Query query;
  private ResultSet result;
  private List<Deck> userDecks;
  private Entry<Integer, String> user;
  private final Map<Integer, Entry<String, String>> questions;
  private final List<Answer> answers;
  private final ArrayList<Question> questionList;

  public FlashCardDatabase() {
    this(Database.INSTANCE);
  }

  // Might be useless
  public FlashCardDatabase(Database database) {
    this.query = new QueryImpl(database);
    this.userDecks = new ArrayList<>();
    this.questions = new HashMap<>();
    this.answers = new ArrayList<>();
    this.questionList = new ArrayList<>();
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
  public void callAPI() throws SQLException, IOException {
    this.setUser(1); // TODO: Change this to the current user

    this.result = this.query.SELECT("*").FROM("deck").WHERE("user_id = " + this.user.getKey()).query();

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
  private Question[] getQuestions(String deckName) throws SQLException, IOException {
    this.result = this.query
            .SELECT("*")
            .FROM("users u")
            .JOIN("deck d").ON("u.user_id = d.user_id")
            .JOIN("question q").ON("d.deck_id = q.deck_id")
            .JOIN("question_type qt").ON("q.question_type_id = qt.question_type_id")
            .WHERE("u.user_id = " + this.user.getKey())
            .AND("d.name = '" + deckName + "'")
            .query();

    // Create a heiarchy
    // Query -> Select, Insert Into, Delete, Update
    // Select -> From, Where, Join, Group By, Order By, Having, Union, Intersect, Except
    // Insert Into -> Table, Values, Select
    // Delete -> From, Where, Join, Group By, Order By, Having, Union, Intersect, Except
    // Update -> Table, Set, Where, Join, Group By, Order By, Having, Union, Intersect, Except
    //"SELECT *"
    //            z+ "FROM users u "
    //            + "JOIN deck d ON u.user_id = d.user_id "
    //            + "JOIN question q ON d.deck_id = q.deck_id "
    //            + "JOIN question_type qt ON q.question_type_id = qt.question_type_id "
    //            + "WHERE u.user_id = " + this.user.getKey() + " AND d.name = '" + deckName + "'"

    // QUERY: Gets the question's text, type
    while (this.result.next()) {
      questions.put(this.result.getInt("question_id"),
              new SimpleEntry<>(this.result.getString("question"),
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
  private Answer[] getAnswers() throws SQLException, IOException {
    for (Map.Entry<Integer, Map.Entry<String, String>> question : questions.entrySet()) {
      this.result = this.query.SELECT("*")
              .FROM("answers")
              .WHERE("question_id = " + question.getKey()).query();

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
  // TODO: Refactor this method
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
   * Sets the id of the user and the user's name into an Abstract hashmap.
   * This is used to store the user's id and name in the session.
   *
   * @param id the user's id
   */
  private void setUser(int id) throws SQLException, IOException {
    this.userDecks = new ArrayList<>();
    this.result = this.query.SELECT("*").FROM("users").WHERE("user_id = " + id + ";").query();

    /* QUERY: Gets the username and user id and stores them in a hashmap */
    this.result.next();
    int userID = this.result.getInt("user_id");
    String name = this.result.getString("name");
    this.user = new SimpleEntry<>(userID, name);
  }
}