import java.sql.SQLException;

import model.Database.FlashCardDatabase;

public class test {
  public static void main(String[] args) throws SQLException {
    FlashCardDatabase database = new FlashCardDatabase();
    database.callAPI();
  }
}
