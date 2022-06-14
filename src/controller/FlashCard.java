//package controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Scanner;
//
//
//import model.Cards.AbstractQuestion;
//import model.Cards.Answer;
//import model.Cards.CorrectAnswer;
//import model.Cards.Deck;
//import model.Cards.IncorrectAnswer;
//import model.Cards.MultipleChoiceAnswer;
//import model.Cards.Question;
//import view.QuestionTextView;
//import view.QuestionView;
//
//public class FlashCard implements QuestionController{
//  private QuestionView view;
//  private Deck deck;
//  private final Readable readable;
//  private final ArrayList<Answer> answers;
//
//
//
//  public FlashCard(QuestionView view, Deck deck, Readable readable)
//    throws IllegalArgumentException {
//    if (view == null || readable == null || deck == null) {
//      throw new IllegalArgumentException("Cannot be null");
//    }
//
//    this.view = view;
//    this.deck = deck;
//    this.readable = readable;
//    this.answers = new ArrayList<Answer>();
//  }
//
//
//  @Override
//  public void run() throws IllegalStateException, IOException {
//    Scanner sc = new Scanner(readable);
//    boolean quit = false;
//    ArrayList<Answer> answers = new ArrayList<Answer>();
//    String asked = "";
//
//    writeMessage(String.format("Good %s User!", checkTime()));
////    writeMessage("Show all decks? (y/n)");
//    writeMessage("Play deck? (y/n)");
//    if (sc.nextLine().equals("y")) {
//      this.view.render();
//    } else {
//      writeMessage("Create new deck: ");
//      writeMessage("Deck name: ");
//      String deckName = sc.nextLine();
//      writeMessage("Add a question? (y/n)");
//      if (sc.nextLine().equals("y")) {
//        writeMessage("Question: ");
//        asked = sc.nextLine();
//        writeMessage("Correct Answer 1: ");
//        String correctAnswer = sc.nextLine();
//        answers.add(new CorrectAnswer(correctAnswer));
//        writeMessage("Answer 2: ");
//        String answer1 = sc.nextLine();
//        answers.add(new IncorrectAnswer(answer1));
//        writeMessage("Answer 3: ");
//        String answer2 = sc.nextLine();
//        answers.add(new IncorrectAnswer(answer2));
//        writeMessage("Answer 4: ");
//        String answer3 = sc.nextLine();
//        answers.add(new IncorrectAnswer(answer3));
//      } else {
//        quit = true;
//        sc.close();
//      }
//
//      Question question = new MultipleChoiceAnswer(asked, answers);
//      this.deck.add(question);
//
//      for (Deck it = this.deck; it.hasNext(); ) {
//        Question q = it.next();
//        this.view = new QuestionTextView(q);
//        this.view.render();
//      }
//    }
//
//    String answer = sc.nextLine();
//    String question = sc.nextLine();
//
//
////
////    while (!quit) {
////      System.out.println("Add the correct answer: \n");
////      String answer = sc.nextLine();
////      Answer correctAnswer = new CorrectAnswer(question);
////      answers.add(correctAnswer);
////      if (!question.equals("x")) {
////          System.out.println("Add the incorrect answers (x to stop): ");
////          Answer incorrectAnswer = new IncorrectAnswer(sc.nextLine());
////          answers.add(incorrectAnswer);
////        } else {
////            quit = true;
////        }
////    }
////
////    model = new MultipleChoiceAnswer(question, answers);
//
//  }
//
//  private void writeMessage(String message) throws IOException {
//    this.view.render(message+"\n");
//  }
//
//  private String checkTime() {
//    Calendar rightNow = Calendar.getInstance();
//    int hour = rightNow.get(Calendar.HOUR_OF_DAY);
//    if (hour < 12) {
//      return "morning";
//    }
//    if (hour < 18) {
//      return "afternoon";
//    }
//    return "evening";
//  }
//}
