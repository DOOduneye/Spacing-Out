package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Answer;
import model.CorrectAnswer;
import model.Deck;
import model.DeckImpl;
import model.IncorrectAnswer;
import model.LongAnswer;
import model.MultipleChoiceAnswer;
import model.Question;
import model.ShortAnswer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class QuestionGUIView extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws SQLException {

//    this.setUser(this.result.getString("name"),
//                this.result.getInt("user_id"));
//
//    System.out.println(this.user.get("david"));

//    this.result = this.executeQuery("SELECT name, description FROM deck");
//
//
//    while (result.next()) {
//      deck.append("Deck name: ")
//              .append(result.getString("name"))
//              .append("\n").append("Description: ")
//              .append(result.getString("description"))
//              .append("\n\n");
//    }
//
//    System.out.println(deck);


//    primaryStage.setTitle("User -- \u2014 Spacing Out");
//    primaryStage.setHeight(200);
//    primaryStage.setWidth(350);
//    primaryStage.setResizable(true);
//
//
//    Label label = new Label("Welcome to Spacing Out!");
//
//    Hyperlink link = new Hyperlink("Back to Home");
//
//    VBox vBox = new VBox(label, link);
////    vBox.setStyle("-fx-alignment: center;");
//
//
//    primaryStage.setScene(new Scene(vBox));
//    primaryStage.show();
  }

}