package model;

import java.sql.SQLException;

import javax.xml.crypto.Data;

public class test {
  public static void main(String[] args) throws SQLException {
    Databases db = Databases.INSTANCE;
    db.openConnection();
    db.callAPI(); // TODO: Handle SQL exceptions
    Databases db2 = Databases.INSTANCE;
    db2.openConnection();
    db2.callAPI(); // TODO: Handle SQL exceptions
    db.closeConnection();
  }
}
