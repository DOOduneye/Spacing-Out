package model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

import model.Cards.Answers.Answer;
import model.Cards.Answers.AnswerFactory;
import model.Cards.Answers.AnswerType;
import model.Cards.Decks.Deck;
import model.Cards.Decks.DeckBuilder;
import model.Cards.Questions.Question;
import model.Cards.Questions.QuestionBuilder;
import model.Cards.Questions.QuestionType;
import model.Query.Query;
import model.Query.QueryImpl;

public class CardData {
  private final Query query;
  private ResultSet result;
  private Entry<Integer, String> user;
  private final HashMap<String, QuestionType> types;

  /**
   * Constructs a {@code CardData}.
   */
  public CardData() {
    this(Database.INSTANCE);
  }

  /**
   * Constructs an {@code CardData} with the given {@code query}.
   *
   * @param database the {@code Database} to be used in the game
   */
  public CardData(Database database) {
    this.query = new QueryImpl(database);
    this.types = new HashMap<>();
    this.setType();
  }

  /**
   * Collects the SQL data from the database, and stores it in the appropriate data structures.
   *
   * <ul>
   * Data such as:
   * <li>user_id</li>
   * <li>deck name</li>
   * <li>deck description</li>
   * <li>questions</li>
   * <li>answers</li>
   * </ul>
   *
   * @throws SQLException if the database cannot be accessed
   */
  public List<Deck> instantiate(int id) throws SQLException {
    this.setUser(id);

    return this.getDecks();
  }

  /**
   * Gets a hashmap of the user's names and ids.
   *
   * @return a hashmap of the user's names and ids
   * @throws SQLException if the database cannot be accessed
   */
  public HashMap<String, Integer> getUsers() throws SQLException {
    HashMap<String, Integer> users = new HashMap<>();

    this.result = this.query.SELECT("*").FROM("users").query();

    while (this.result.next()) {
      users.put(this.result.getString("name"), this.result.getInt("user_id"));
    }

    return users;
  }

  /**
   * Collects all decks from the database, for the given user.
   *
   * @return a map of deck names and descriptions
   */
  private List<Deck> getDecks() throws SQLException {
    List<Deck> decks = new ArrayList<>();

    this.result = this.query
            .SELECT("*").FROM("deck")
            .WHERE("user_id = " + this.user.getKey())
            .query();

    // QUERY: Gets the users decks name and description and puts them in a list of decks
    while (this.result.next()) {
      decks.add(new DeckBuilder().name(this.result.getString("name")).description(this.result.getString("description")).build());
    }

    for (Deck deck : decks) {
      deck.addAll(this.getQuestions(deck.getName()));
    }

    return decks;
  }

  /**
   * Sets the type of the questionType hashmap.
   */
  private void setType() {
    this.types.put("MULTIPLE_CHOICE", QuestionType.MULTIPLE_CHOICE);
    this.types.put("SHORT_RESPONSE", QuestionType.SHORT_RESPONSE);
    this.types.put("LONG_RESPONSE", QuestionType.LONG_RESPONSE);
    this.types.put("FILL_IN_THE_BLANK", QuestionType.FILL_IN_THE_BLANK);
  }

  /**
   * Collects the questions from the database.
   *
   * @return the questions
   * @throws SQLException if the query fails
   */
  private List<Question> getQuestions(String deckName) throws SQLException {
    List<Question> questions = new ArrayList<>();

    this.result = this.query
            .SELECT("*")
            .FROM("users u")
            .JOIN("deck d").ON("u.user_id = d.user_id")
            .JOIN("question q").ON("d.deck_id = q.deck_id")
            .JOIN("question_type qt").ON("q.question_type_id = qt.question_type_id")
            .WHERE("u.user_id = " + this.user.getKey())
            .AND("d.name = '" + deckName + "'")
            .query();

    // QUERY: Gets the question's text, type
    while (this.result.next()) {
      Question q = new QuestionBuilder()
              .setQuestion(this.result.getString("question"))
              .setType(this.types.get(this.result.getString("question_type")))
              .addAllAnswers(this.getAnswers(this.result.getInt("question_id")))
              .build();

      questions.add(q);
    }

    return questions;
  }


  /**
   * Collects the answers from the database for the given question.
   *
   * @return the answers
   * @throws SQLException if the query fails
   */
  private List<Answer> getAnswers(int id) throws SQLException {
    List<Answer> answers = new ArrayList<>();
    this.result = this.query.SELECT("*")
            .FROM("answers")
            .WHERE("question_id = " + id).query();

    // QUERY: Gets the answer's text, correct/incorrect
    while (this.result.next()) {
      AnswerType type = this.result.getBoolean("is_correct") ? AnswerType.CORRECT :
              AnswerType.INCORRECT;
      String answer = this.result.getString("answer");

      answers.add(new AnswerFactory().createAnswer(answer, type));
    }

    return answers;
  }

  /**
   * Sets the id of the user and the user's name into an Abstract hashmap.
   * This is used to store the user's id and name in the session.
   *
   * @param id the user's id
   */
  private void setUser(int id) throws SQLException {
    this.result = this.query.SELECT("*").FROM("users")
            .WHERE("user_id = " + id + ";").query();

    /* QUERY: Gets the username and user id and stores them in a hashmap */
    this.result.next();

    this.user = new SimpleEntry<>(this.result.getInt("user_id"), this.result.getString("name"));
  }
}