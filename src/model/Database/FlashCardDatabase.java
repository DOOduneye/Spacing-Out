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

import model.Cards.Answers.Answer;
import model.Cards.Answers.CorrectAnswer;
import model.Cards.Decks.Deck;
import model.Cards.Decks.DeckImpl;
import model.Cards.Answers.IncorrectAnswer;
import model.Cards.Questions.Long;
import model.Cards.Questions.MC;
import model.Cards.Questions.Question;
import model.Cards.Questions.Short;
import model.Query.Query;
import model.Query.QueryImpl;

public class FlashCardDatabase {
  private final Query query;
  private ResultSet result;
  private List<Deck> userDecks;
  private Entry<Integer, String> user;
  private final List<Answer> answers;
  private final ArrayList<Question> questionList;

  public FlashCardDatabase() {
    this(Database.INSTANCE);
  }

  // Might be useless
  public FlashCardDatabase(Database database) {
    this.query = new QueryImpl(database);
    this.userDecks = new ArrayList<>();
    this.answers = new ArrayList<>();
    this.questionList = new ArrayList<>();
  }

  /**
   * Collects the SQL data from the database, and stores it in the appropriate data structures.
   *
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
  public void instantiateFlashCard(int id) throws SQLException, IOException {
    this.setUser(id);

    for (Entry<String, String> deck : this.getDecks().entrySet()) {
//      System.out.println(deck.getKey() + ": " + deck.getValue());
      this.userDecks.add(new DeckImpl(deck.getKey(), deck.getValue(), this.getQuestions(deck.getKey())));
//      System.out.println(this.userDecks.size());
    }
  }

  /**
   * Collects the decks from the database.
   *
   * @return a map of deck names and descriptions
   */
  private HashMap<String, String> getDecks() {
    HashMap<String, String> deckContent = new HashMap<>();

    this.result = this.query
            .SELECT("*").FROM("deck")
            .WHERE("user_id = " + this.user.getKey()).query();

    // QUERY: Gets the users decks, all content
    try {
      while (this.result.next()) {
        deckContent.put(this.result.getString("name"), this.result.getString("description"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return deckContent;
  }

  /**
   * Collects the questions from the database.
   *
   * @return the questions
   * @throws SQLException if the query fails
   */
  private List<Question> getQuestions(String deckName) throws SQLException {
    HashMap<Integer, Entry<String, String>> questions = new HashMap<>();

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
      questions.put(this.result.getInt("question_id"),
              new SimpleEntry<>(this.result.getString("question"),
                      this.result.getString("question_type")));

    }

//    this.getAnswers();

    return this.questionList;
  }


  /**
   * Collects the answers from the database.
   *
   * @return the answers
   * @throws SQLException if the query fails
   */
  private List<Answer> getAnswers(HashMap<Integer, Entry<String, String>> questions) throws SQLException {
    for (Entry<Integer, Map.Entry<String, String>> question : questions.entrySet()) {
      this.result = this.query.SELECT("*")
              .FROM("answers")
              .WHERE("question_id = " + question.getKey()).query();

      // QUERY: Gets the answer's text, correct/incorrect
      while (this.result.next()) {
        String answer = this.result.getString("answer");
        boolean correct = this.result.getBoolean("is_correct");

        answers.add(correct ? new CorrectAnswer(answer) : new IncorrectAnswer(answer));
      }

//      this.setType(question);

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
//  private void setType(Map.Entry<Integer, Map.Entry<String, String>> question) {
//    switch (question.getValue().getValue()) {
//      case "multiplechoice":
//        questionList.add(new MC(question.getValue().getKey(),
//                new ArrayList<>(answers)));
//        break;
//      case "shortanswer":
//        questionList.add(new Short(question.getValue().getKey(),
//                new ArrayList<>(answers)));
//        break;
//      case "longanswer":
//        questionList.add(new Long(question.getValue().getKey(),
//                new ArrayList<>(answers)));
//        break;
//      default:
//        break;
//    }
//  }

  /**
   * Sets the id of the user and the user's name into an Abstract hashmap.
   * This is used to store the user's id and name in the session.
   *
   * @param id the user's id
   */
  private void setUser(int id) throws SQLException {
    this.userDecks = new ArrayList<>();

    this.result = this.query
            .SELECT("*")
            .FROM("users")
            .WHERE("user_id = " + id + ";").query();

    /* QUERY: Gets the username and user id and stores them in a hashmap */
    this.result.next();

    this.user = new SimpleEntry<>(this.result.getInt("user_id"), this.result.getString("name"));
  }
}