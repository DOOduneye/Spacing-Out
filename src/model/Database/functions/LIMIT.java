package model.Database.functions;

import java.util.function.Function;

public class LIMIT implements Function<String, String> {

  @Override
  public String apply(String s) {
    return " LIMIT " + s;
  }

}
