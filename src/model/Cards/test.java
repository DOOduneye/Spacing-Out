package model.Cards;


import java.util.ArrayList;
import java.util.List;

import model.Cards.Answers.Answer;
import model.Cards.Answers.AnswerFactory;
import model.Cards.Answers.AnswerType;
import model.Cards.Questions.Question;
import model.Cards.Questions.QuestionBuilder;
import model.Cards.Questions.QuestionType;
import model.Utils;

public class test {
  public static void main(String[] args) {
    Question question = new QuestionBuilder()
            .setQuestion("What is the capital of France?")
            .addAnswer("Paris", AnswerType.CORRECT)
            .addAnswer("London", AnswerType.INCORRECT)
            .addAnswer("Berlin", AnswerType.INCORRECT)
            .addAnswer("Madrid", AnswerType.INCORRECT)
            .setType(QuestionType.MULTIPLE_CHOICE).build();

    Question question2 = new QuestionBuilder()
            .setQuestion("What is the capital of the UK?")
            .addAnswer("London", AnswerType.CORRECT)
            .addAnswer("Paris", AnswerType.INCORRECT)
            .addAnswer("Berlin", AnswerType.INCORRECT)
            .addAnswer("Madrid", AnswerType.INCORRECT)
            .setType(QuestionType.MULTIPLE_CHOICE).build();

    Answer answerFactory = new AnswerFactory().createAnswer("Paris", AnswerType.CORRECT);
    System.out.println(answerFactory.getType());

    List<String> answers = new ArrayList<>();
    answers.add("Paris");
    answers.add("London");

    List<String> answers2 = new ArrayList<>();
    answers2.add("London");
    answers2.add("Paris");

    System.out.println(Utils.compareList(answers, answers2));

//    Deck deck = new Deck.DeckBuilder().name("Capitals").description("Capitals of the world")
//            .add(question).add(question2).build();
  }
}