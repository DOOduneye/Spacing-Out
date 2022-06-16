package model.Cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Cards.Answers.Answer;
import model.Cards.Answers.AnswerType;
import model.Cards.Answers.CorrectAnswer;
import model.Cards.Answers.IncorrectAnswer;
import model.Cards.Decks.Deck;
import model.Cards.Decks.DeckImpl;
import model.Cards.Questions.MC;
import model.Cards.Questions.Question;

public class test {
  public static void main(String[] args) {
    List<AnswerType> answersList = new ArrayList<>();
    answersList.add(AnswerType.INCORRECT("testss"));
    answersList.add(AnswerType.CORRECT("testss"));
    System.out.println(answersList.get(0).getAnswer());


//
//    HashMap<String, AnswerType> answers2 = new HashMap<>();
//    answers2.put("Correct answer 3", AnswerType.CORRECT);
//    answers2.put("Correct answer 4", AnswerType.CORRECT);
//    answers2.put("Incorrect answer 2", AnswerType.INCORRECT);
//
//    Question q1 = new MC("Question 1", answers);
//    q1.getAnswers().keySet().forEach(System.out::println);
//
//    Question q2 = new MC("Question 2", answers);
//    q2.getAnswers().keySet().forEach(System.out::println);

//    Deck d1 = new DeckImpl("Deck 1", "Description 1", answersList);

  }

}
