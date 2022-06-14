import java.sql.SQLException;

import model.Database.Database;

public class test {
  public static void main(String[] args) throws SQLException {
    Database database = Database.INSTANCE;
    database.callAPI();
    database.close();

  }
}
