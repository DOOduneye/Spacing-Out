//package view;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.*;
//import java.util.ArrayList;
//
//import controller.QuestionController;
//import model.AbstractQuestion;
//import model.Answer;
//import model.Deck;
//import model.Decks;
//import model.MultipleChoiceAnswer;
//import model.Question;
//
//public class FlashCardProgram {
//
//  public static void main(String[] args) throws SQLException, IOException {
//    // Connect to the database
//    String userName = "root";
//    String password = "Kshkyvr1";
//    String url = "jdbc:mysql://localhost:3306/questiondata";
//    String query = "";
//
//    try {
//      Class.forName("com.mysql.cj.jdbc.Driver");
//    } catch (ClassNotFoundException e) {
//      System.out.println("Where is your MySQL JDBC Driver?");
//      e.getStackTrace();
//    }
//
//    try {
//      Connection connection = DriverManager.getConnection(url, userName, password);
//      // Create a statement
//      Statement statement = connection.createStatement();
//
//      // Create a query
//      query = "SELECT answer FROM answers WHERE question_id = 3 AND is_Correct;";
//
//      // Execute the query
//      ResultSet result = statement.executeQuery(query);
//
//      StringBuilder data = new StringBuilder();
//
//      // Iterate through the result set
//      while (result.next()) {
//        data.append(result.getString("answer"));
//      }
//
//      System.out.println(data.toString());
//
//
//      while (result.next()) {
//        data.append("Question: ").append(result.getString("question")).append("\n");
//        data.append("Answer: ").append(result.getString("answer")).append("\n");
//      }
//      System.out.println(data.toString());
//      result.close();
//
//    } catch (SQLException e) {
//      e.getStackTrace();
//    }
//
//    ArrayList<Answer> answers = new ArrayList<>();
//    AbstractQuestion model = new MultipleChoiceAnswer("Question", answers);
//    Question[] questions = {model};
//    Deck deck = new Decks("Test deck", questions);
//
//
//    Readable rd = new InputStreamReader(System.in);
//    Appendable ap = System.out;
//
//    QuestionView view = new QuestionTextView(model, ap);
//
//    QuestionController controller = new FlashCard(view, deck, rd);
//    controller.run();
//
//  }
//}