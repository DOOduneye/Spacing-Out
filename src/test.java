import controller.Controller;
import controller.ControllerImpl;

public class test {
  public static void main(String[] args)  {
//    CardData database = new CardData();
//
//    try {
//      List<Deck> decks = database.instantiate(1);
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }

    Controller controller = new ControllerImpl();
    controller.run();

  }
}
