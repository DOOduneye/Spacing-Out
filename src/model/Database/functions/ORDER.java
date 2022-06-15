package model.Database.functions;

import java.util.function.Function;

public class ORDER implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " ORDER BY " + s;
  }

}
