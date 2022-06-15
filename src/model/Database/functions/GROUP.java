package model.Database.functions;

import java.util.function.Function;

public class GROUP implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " GROUP BY " + s;
  }
}
